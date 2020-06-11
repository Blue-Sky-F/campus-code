import os
import requests
import json
#爬取百度图片中的照片

def getPages(keyword, pages):#关键词，页面数
    url = 'https://image.baidu.com/search/acjson'
    params = []
    for i in range(30, 30*pages+30, 30):
        params.append({'tn': 'resultjson_com',
                      'ipn': 'rj',
                      'ct': 201326592,
                      'is': '',
                      'fp': 'result',
                      'queryWord': keyword,
                      'cl': 2,
                      'lm': -1,
                      'ie': 'utf-8',
                      'oe': 'utf-8',
                      'adpicid': '',
                      'st': -1,
                      'z': '',
                      'ic': 0,
                      'word': keyword,
                      's': '',
                      'se': '',
                      'tab': '',
                      'width': '',
                      'height': '',
                      'face': 0,
                      'istype': 2,
                      'qc': '',
                      'nc': 1,
                      'fr': '',
                      'pn': i,
                      'rn': 30,
                      'gsm': '',
                      '1488942260214': ''})
    datalist = []
    for i in params:
        datalist.append(requests.get(url,i).json().get('data'))
        #datalist.append(json.loads((requests.get(url,i).text)).get('data')) #与上条代码效果一样

    return datalist

def getImg(datalist, path):
    os.chdir(path)
    x = 1
    for list in datalist:
        for i in list:
            if i.get('thumbURL')!=None:
                print('正在下载图片：{}'.format(i.get('thumbURL')))
                ir = requests.get(i.get('thumbURL'))  
                with open('{}.png'.format(x),'wb') as f:                  
                    f.write(ir.content)
                x +=1
            else:
                print('图片下载出错!')
    print('共下载{}张照片'.format(x-1))
            

      
if __name__ == "__main__":
    datalist = getPages('科比',0)
    getImg(datalist, 'C:\\Users\\徐翼飞\\Desktop\\spide')

    


