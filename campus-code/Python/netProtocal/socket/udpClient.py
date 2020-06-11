# Create a udpClient

from socket import*

HOST = 'localhost'
PORT = 21568
BUFSIZE = 1024
ADDR = (HOST, PORT)

udpClient = socket(AF_INET, SOCK_DGRAM)

while True:
    data = input('>>')
    if not data:
        break
    data = data.encode('utf-8')
    udpClient.sendto(data,ADDR)
    data, ADDR = udpClient.recvfrom(BUFSIZE)
    if not data:
        break
    print(data.decode('utf-8'))
udpClient.close()
