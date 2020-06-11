import requests
from bs4 import BeautifulSoup


html = requests.get('http://www.zuihaodaxue.cn/zuihaodaxuepaiming2016.html')
html.encoding = 'utf-8'
soup = BeautifulSoup(html.text, 'html.parser')
tr = soup.find_all('tr')
data = []
for i in tr:
	try:    
	        name = i.find('div', align = 'left').string
	        address = i.find_all('td')[2].string
	        grades = i.find_all('td')[3].string
	        data.append ([name,address,grades])
	except:
		continue
alt ='{:<8}{:15s}{:12s}{:<12}'
def printf():
	print(alt.format ('排名','学校','地址','评分'))
	i =1
	for d in data:
		try:		
		        print(alt.format(i,d[0],d[1],d[2]))
		        i =i+1
		except:
			continue

def search(name):
        j =1
        for d in data:
                if(d[0]==name):
                        print(alt.format ('排名','学校','地址','评分'))
                        print(alt.format(j,d[0],d[1],d[2]))
                        return
                j = j+1
        print('无'+name+'的排名')
                        
if __name__ == "__main__":
     search("大连海事大学")                       
