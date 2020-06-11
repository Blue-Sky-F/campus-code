#Create a tcp Sercver
from socket import*
from time import ctime

HOST =''
PORT = 21569
BUFSIZE = 1024
ADDR = (HOST, PORT)

tcpSerSock = socket(AF_INET, SOCK_STREAM)
tcpSerSock.bind(ADDR)
tcpSerSock.listen(5)

while True:
    print("waiting for connection...")
    tcpCliSock ,addr = tcpSerSock.accept()
    print("connect from",addr)

    while True:
        data = tcpCliSock.recv(BUFSIZE)
        if not data:
            break
        print("Receive:"+data.decode('utf-8')+" from"+str(addr))
        ctim = (ctime()+"  ").encode('utf-8')
        data = input('>>')
        if not data:
            break
        data = data.encode('utf-8')
        tcpCliSock.send(ctim+data)
    tcpCliSock.close()
    break
print("连接关闭...")         
tcpSerSock.close()
