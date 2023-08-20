import sys
from collections import deque

input = sys.stdin.readline

n = int(input().strip())

cnt_list = [0 for _ in range(10001)]

for _ in range(n):
    cnt_list[int(input().strip())] += 1

for i in range(10001):
    for j in range(cnt_list[i]):
        print(i)