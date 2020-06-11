#Create a tcp Client
from socket import*

#HOST = 'localhost'
HOST = '192.168.43.29'
PORT = 21569
BUFSIZE = 1024
ADDR = (HOST,PORT)

tcpClient = socket(AF_INET, SOCK_STREAM)
tcpClient.connect(ADDR)

while True:
    data = input('>>')
    if not data:
        break
    data = data.encode('utf-8')        
    tcpClient.send(data)
    data = tcpClient.recv(BUFSIZE)
    if not data:
        break
    data = data.decode('utf_8')
    print(data)
print("连接关闭...") 
tcpClient.close()
