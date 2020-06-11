#微信好友分析
import re
from wxpy import *
bot = Bot()

def sex(bot):#返回一个包含好友男女人数的字典
      friends = bot.friends ()
      sex_dict = {'male':0, 'female':0}
      for friend in friends:
            if friend.sex == 1:
                  sex_dict['male'] +=1
            elif friend.sex == 2:
                  sex_dict['female'] +=1
      return sex_dict

def map(bot):#返回一个好友省份分布的列表
      friends = bot.friends ()
      # 使用一个字典统计各省好友数量
      province_dict ={
      '北京': 0, '上海': 0, '天津': 0, '重庆': 0,'河北': 0,'山西': 0, '吉林': 0, '辽宁': 0, '黑龙江': 0,'陕西': 0, '甘肃': 0, '青海': 0, '山东': 0, '福建': 0, '浙江': 0, '台湾': 0, '河南': 0, '湖北': 0, '湖南': 0,'江西': 0, '江苏': 0, '安徽': 0, '广东': 0, '海南': 0,'四川': 0, '贵州': 0, '云南': 0,'内蒙古': 0, '新疆': 0,'宁夏': 0, '广西': 0, '西藏': 0,'香港': 0, '澳门': 0
      }
      #统计省份
      for friend in friends:
            if friend.province in province_dict.keys():
                  province_dict[friend.province] +=1
      data = []
      for key ,value in province_dict.items():
            data.append({'name':key,'value':value})
      return data

def signatures(bot):#以文件形式存储好友的签名
      friends = bot.friends ()
      sig = []
      for friend in friends:
            sig.append(friend.signature)
            #pattern = re.compile(r'[一-龥]+')
            #filterdata = re.findall(pattern,friend.signature)
            try:
                  write_txt_file('signatures.txt',' '.join(friend.signature))
            except:
                  pass
      return sig
def write_txt_file(path,txt):#写入文本
      with open(path,'a',encoding ='gb18030',newline='') as f:
                f.write(txt)

def read_signatures(path):#读取文本
      with open(path,'r',encoding='gb18030',newline='')as f:
            return f.read()

      
      
    

                  
      

      
      
