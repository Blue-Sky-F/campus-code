import requests
from bs4 import BeautifulSoup

html = requests.get('https://python123.io/ws/demo.html')
soup = BeautifulSoup(html.text,'html.parser')
p = soup.find_all('p')

