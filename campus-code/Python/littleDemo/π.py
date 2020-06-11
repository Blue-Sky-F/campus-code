from random import random
from math import sqrt

#用概率近视计算π的值
def pi():
    number = 0
    for i in range(10000000):
        x = random()
        y = random()
        len = sqrt(x * x + y * y)
        if (len <= 1):
            number += 1
    return (float)(4 * number / 10000000)
