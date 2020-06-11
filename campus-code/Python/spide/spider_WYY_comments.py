#------抓取网易云音乐评论------#
#import matplotlib.pyplot as plt
from wordcloud import WordCloud
from pyecharts import Bar
import requests
import json
import re


#分析url,用于提交post请求
def parser_url(id):
      url = 'http://music.163.com/weapi/v1/resource/comments/R_SO_4_'+id
      #加密数据，直接使用
      headers = {  
   'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299',
   'Referer' : 'http://music.163.com/song?id=',
   'Origin': 'http://music.163.com',
   'Host': 'music.163.com'
   }
      headers['Referer']+=id
      user_data = {
      'params': 'vRlMDmFsdQgApSPW3Fuh93jGTi/ZN2hZ2MhdqMB503TZaIWYWujKWM4hAJnKoPdV7vMXi5GZX6iOa1aljfQwxnKsNT+5/uJKuxosmdhdBQxvX/uwXSOVdT+0RFcnSPtv',
      'encSecKey': '46fddcef9ca665289ff5a8888aa2d3b0490e94ccffe48332eca2d2a775ee932624afea7e95f321d8565fd9101a8fbc5a9cadbe07daa61a27d18e4eb214ff83ad301255722b154f3c1dd1364570c60e3f003e15515de7c6ede0ca6ca255e8e39788c2f72877f64bc68d29fac51d33103c181cad6b0a297fe13cd55aa67333e3e5'
}
      return [url,headers,user_data]
      
      

#获取昵称、热门评论、点赞数
def parser_hot_comments(id):
      u_parser = parser_url(id)
      response = requests.post(u_parser[0],headers=u_parser[1],data=u_parser[2])
      data = json.loads(response.text)
      hotcomments = []
      for hotcomment in data['hotComments'] :
            item = {
                  'nickname':hotcomment['user']['nickname'],
                  'content':hotcomment['content'],
                  'likedCount':hotcomment['likedCount']
                  }
            hotcomments.append(item)
      content_list = [content['content'] for content in hotcomments]
      nickname = [content['nickname'] for content in hotcomments]
      liked_count = [content['likedCount'] for content in hotcomments]
      return [nickname,content_list,liked_count]
      

#打印抓取的数据
def print_comments(data):
      #print('{}\t{}\t\t\t{}\t\t\t{}'.format('序号','网友','评论','点赞数'))
      for i in range(len(data[0])):
            try:
                  print('{}\t{}\t{}\t{}'.format(i+1,data[0][i],data[1][i],data[2][i]))
            except:
                  pass
#生成图表
def print_graph(data):
      bar = Bar('热评点赞示意图')
      bar.add('点赞数',data[0],data[2],is_stack=True,mark_line=['min','max'],mark_point=['average'])
      bar.render()

      
if __name__ == "__main__":
      #通过歌曲id找到网易云热评
      data = parser_hot_comments('557248847')
      print_comments(data)
      #print_graph(data)

            
            
      
      
      

