#FTP 下载实例

import ftplib
import os
import socket

HOST = "ftp.mozilla.org"
DIRN = "pub/mozilla.org/webtools"
FILE = "bugzilla-LATEST.tar.gz"

def main():
    try:
        f = ftplib.FTP(HOST)
    except (socket.error, socket.gaierror) as e:
        print("ERROR: cannot reach:{} ".format(HOST))
        return
    print("Connected to:{}".format(HOST))





if  __name__ =="__main__":
    main()
