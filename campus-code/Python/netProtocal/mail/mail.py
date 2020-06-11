
from smtplib import SMTP
from email.header import Header
from email.mime.text import MIMEText
def mian():
    sender = '1471844027@qq.com'
    receivers = ['1471844027@qq.com']
    message = MIMEText('发送邮件', 'plain', 'utf-8')
    message['From'] = Header('Eason', 'utf-8')
    message['To'] = Header('Bob','utf-8')
    message['Subject'] = Header('实验邮件','utf-8')
    smtper = SMTP('smtp.126.com')
    try:
        smtper.login(sender,'abc1471844027')
        smtper.sendmail(sender, receivers, message.as_string())
        print('邮件发送完毕!')
    except:
        print("登录失败!")
if __name__ == '__main__':
    mian()



