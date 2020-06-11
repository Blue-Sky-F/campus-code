import requests
import re
from bs4 import BeautifulSoup

def getHtml(url):
      try:
            html = requests.get(url)
            html.encoding = 'utf-8'
            html.raise_for_status()
            return  html.text
      except:
            pass

def getSoup(url):
      html = getHtml(url)
      soup = BeautifulSoup(html, 'html.parser')
      return soup

#--------打印豆瓣影评--------#
def print_Douban(number,n):#爬取n个页面的数据
      url = 'https://movie.douban.com/subject/{}/comments?start={}&limit=20&sort=new_score&status=P'
      comment = []
      for i in range(n):
            c_url = url.format(number, i*20)
            soup = getSoup(c_url)
            div = soup.find_all('div',class_='comment-item')
            for d in div:
                  try:
                        name = d.a['title']
                        cm = d.p.span.string
                        comment.append([name,cm])
                  except:
                        pass
      for c in comment:
            try:
                  print("{:20s}{}".format(c[0],c[1]))
            except:
                  pass
                  
#---------爬取京东手机商品的数据--------#
def print_JD(keyword,n):#爬取n个页面的数据
      url = 'https://search.jd.com/Search?keyword={}&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&page={}'
      redex = re.compile(r'<.*?>')
      data = []
      for i in range(n):#n个页面
            c_url = url.format(keyword, 2*i+1)
            soup = getSoup(c_url)
            div1 = soup.find_all('div',class_='p-price')
            div2 = soup.find_all('div', class_='p-name p-name-type-2')
            for i in range(len(div1)):
                  try:
                        name = re.sub(redex,'',str(div2[i].em))
                        price = div1[i].i.string
                        data.append([name,price])
                  except:
                        pass
      i =1
      for d in data:
            try:
                  print(i,'\t',d[0].split(' ')[0],'\t',d[0].split(' ')[2],'\t',d[1])
                  #print('{:<5}{:10s}{:20s}{:8s}'.format(i,d[0].split(' ')[0],d[0].split(' ')[2],d[1]))
                  i +=1
            except:
                  pass
        

      
      
              
                  
	
      
   
