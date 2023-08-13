import sys
from collections import deque

input = sys.stdin.readline

n = int(input().strip())

levels = list(map(int, (input().split())))

for l in levels:
    if l == 300:
        print(1, end=" ")
    elif l >= 275:
        print(2, end=" ")
    elif l >= 250:
        print(3, end=" ")
    else:
        print(4, end=" ")