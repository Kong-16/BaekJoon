import math
import sys

input = sys.stdin.readline

t = 3

for _ in range(t):
    n = int(input().rstrip())
    s = 0
    for _ in range(n):
        s += int(input().rstrip())
    if s == 0:
        print("0")
    elif s < 0:
        print("-")
    else:
        print("+")