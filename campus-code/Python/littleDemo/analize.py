
import xlrd



#设置文件名和路径

fname = 'C:\\Users\\徐翼飞\\Desktop\\1.xlsx'

# 打开文件

filename = xlrd.open_workbook(fname)
sheet=filename.sheet_by_index(1)     #通过sheet索引获得sheet对象
nrows = sheet.nrows
ncols = sheet.ncols

cell_value = sheet.cell_value(1,1)

#获取各行数据

row_list=[]

for i in range(2,nrows):
    row_datas = sheet.row_values(i)
    row_list.append(row_datas)
file_name = ''
f = open(file_name,'w')




 

f.write('hello world!')