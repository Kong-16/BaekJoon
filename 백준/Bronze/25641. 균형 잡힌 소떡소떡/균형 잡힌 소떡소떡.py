import sys
from collections import deque

input = sys.stdin.readline

n = int(input().rstrip())

input_str = input().rstrip()

s_num = 0
t_num = 0
for i in range(n):
    if input_str[i] == 's':
        s_num += 1
    else:
        t_num += 1

idx = 0
while s_num != t_num:
    alp = input_str[idx]
    if alp == 's':
        s_num -= 1
    else:
        t_num -= 1
    idx += 1

print(input_str[idx:])