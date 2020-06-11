import requests
import re
import xlrd
from bs4 import BeautifulSoup
#---------------Step1：获取区块链股票代码---------------#
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
      try:
            soup = BeautifulSoup(html, 'html.parser')
      except:
            pass
      return soup
   
def stockNum(text):
	data = text.split(',')
	data = data[1:-1]
	return data[0::26]
      
def getStockNum(urls):
      data = ''
      try:
            for url in urls:
                  html = getHtml(url)
                  index = html.find('[')
                  data = data+html[index+1:]
      except:
            pass
      return stockNum(data)

url1 = 'http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?cb=jQuery112406502359727533902_1540281919867&type=CT&token=4f1862fc3b5e77c150a2b985b12db0fd&sty=FCOIATC&js=(%7Bdata%3A%5B(x)%5D%2CrecordsFiltered%3A(tot)%7D)&cmd=C.BK08301&st=(ChangePercent)&sr=-1&p=1&ps=20&_=1540281919903'
url2 = 'http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?cb=jQuery112406502359727533902_1540281919865&type=CT&token=4f1862fc3b5e77c150a2b985b12db0fd&sty=FCOIATC&js=(%7Bdata%3A%5B(x)%5D%2CrecordsFiltered%3A(tot)%7D)&cmd=C.BK08301&st=(ChangePercent)&sr=-1&p=2&ps=20&_=1540281920004'
url3 = 'http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?cb=jQuery112406502359727533902_1540281919867&type=CT&token=4f1862fc3b5e77c150a2b985b12db0fd&sty=FCOIATC&js=(%7Bdata%3A%5B(x)%5D%2CrecordsFiltered%3A(tot)%7D)&cmd=C.BK08301&st=(ChangePercent)&sr=-1&p=3&ps=20&_=1540281920026'
url4 = 'http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?cb=jQuery112406502359727533902_1540281919870&type=CT&token=4f1862fc3b5e77c150a2b985b12db0fd&sty=FCOIATC&js=(%7Bdata%3A%5B(x)%5D%2CrecordsFiltered%3A(tot)%7D)&cmd=C.BK08301&st=(ChangePercent)&sr=-1&p=4&ps=20&_=1540281920054'
url=[url1,url2,url3,url4] #显示区块链行业的股票代码的链接
stocks = getStockNum(url) #储存股票代码的列表

#-------------Step2：根据股票代码从股市通获得股票信息--------#
def getUrls(stocks):
      urls = []  
      url= 'https://gupiao.baidu.com/stock/sz{}.html'
      for i in stocks:
            urls.append(url.format(i))
      return urls
urls = getUrls(stocks)
def getStocksMsg(urls):
      msg = []
      for url in urls:
            soup = getSoup(url)
            try:
                  name = soup.find('div',class_='stock-bets').a.text.split('\n')[1].replace(' ','')[:-8]
                  code = soup.find('div',class_='stock-bets').a.text.split('\n')[1].replace(' ','')[-7:-1]
                  dts = soup.find('div',class_='line1').findAll('dd')
                  today = dts[0].string
                  most = dts[2].string
                  amount = dts[5].string
                  total = dts[10].string
                  msg.append([name,code,today,most,amount,total])
            except:
                  continue
      return msg

def showMsg(msg):
      print('{}\t{}\t{}\t{}\t{}\t{}\t\t{}'.format('序号','股票','代码','今开','最高','成交额','总股本'))
      i = 1
      for m in msg:
            print('{}\t{}\t{}\t{}\t{}\t{}\t\t{}'.format(i,m[0],m[1],m[2],m[3],m[4],m[5]))
            i +=1
def saveInExcel(msg):
      return
      
if __name__ =="__main__":
      msg = getStocksMsg(urls)
      showMsg(msg)

                  
            
            
