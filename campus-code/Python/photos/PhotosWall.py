

from PIL import Image
import os,sys

mw = 200
ms = 25
msize = mw*ms

def photoWall(path):
      toImage = Image.new('RGBA', (5000,5000))
      for y in range(1,25):
            for x in range(1,25):
                  try:
                        fromImage = Image.open(path+'/%s.jpg' %str(ms*(y-1)+x))
                        fromImage = fromImage.resize((200,200),Image.ANTIALIAS)
                        toImage.paste(fromImage, ((x-1)*mw, (y-1)*mw))
                  except IOError:
                        pass
      toImage.show()
      toImage.save(r'C:/Users/徐翼飞/Desktop/群相册 (1)/we.png')
      

def changeColor(path):
      im = Image.open(path)
      im = im.convert('2')
      im.save(path)

