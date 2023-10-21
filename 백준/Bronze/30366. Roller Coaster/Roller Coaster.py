import math
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

groups = list(map(int, input().split()))

capacity = m
time = 0
s = 0
while s < n:
    g = groups[s]
    if g <= capacity:
        print(time)
        capacity -= g
        s += 1
    else:
        time += 1
        capacity = m