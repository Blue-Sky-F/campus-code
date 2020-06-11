# Create a UDP timeServer

from socket import *
from time import ctime

HOST = ''
PORT = 21568
BUFSIZE = 1024
ADDR = (HOST, PORT)

udpserver = socket(AF_INET, SOCK_DGRAM)
udpserver.bind(ADDR)

while True:
    print ('waitinting for message...')
    data, addr = udpserver.recvfrom(BUFSIZE) 
    udpserver.sendto((ctime()+"  ").encode('utf-8')+data,addr)
    print ('...received from and returned to :',addr)
udpserver.close() 