from xml.dom import minidom
from pyecharts import Bar
from pyecharts import configure
import pygal
def getData():
      years = []
      population = []
      doc = minidom.parse("C:/Users/徐翼飞/Desktop/人口.xml")
      root = doc.documentElement
      datas = root.getElementsByTagName('data')
      for data in datas:
            years.append(data.getElementsByTagName('year')[0].childNodes[0].nodeValue)
            population.append(data.getElementsByTagName('population')[0].childNodes[0].nodeValue)         
      return [years,population]   

def renderBar():
      elements = getData()
      years = elements[0]
      population = elements[1]
      configure(global_theme='dark')
      bar =Bar("中国2002-2017人口变化",
               "2018-11-13", title_pos='left',
               title_color='blue',
               width=1300,
               height=680,
               background_color='rgb(241, 244, 245)')
      bar.add("人口数量",
              years,
              population,
              mark_line=['min','max'],
              is_datazoom_show=True,
              datazoom_type = 'both',
              datazoom_range=[25,100],
              xaxis_name="年份",xaxis_label_textcolor="dark",
              yaxis_name="人口(单位/万人)",
              yaxis_name_gap=65,
              yaxis_type="value",
              legend_text_color='blue' )
      bar.render('C:/Users/徐翼飞/Desktop/Population.html')
def render_svg():
      elements = getData()
      years = elements[0]
      population = elements[1]
      popu = []
      for i in population:
            popu.append(int(i))
      bar_chart = pygal.Bar()
      bar_chart.title = "中国2002-2017人口变化"
      bar_chart.x_title = "人口数(单位/万人)"
      bar_chart.y_title = "年份"
      bar_chart.x_labels = years
      bar_chart.add('人口变化',popu)
      bar_chart.render_to_file('C:/Users/徐翼飞/Desktop/Population.svg')
      

if "__name__ == main ":
      #renderBar()
      render_svg()

