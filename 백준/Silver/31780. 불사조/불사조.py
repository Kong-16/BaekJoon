import sys
import math

input = sys.stdin.readline

x, m = map(int, input().split())

old = [x]

tot = x
for _ in range(m):
    new = []
    for num in old:
        up = math.ceil(num / 2)
        down = math.floor(num / 2)
        if up:
            new.append(up)
        if down:
            new.append(down)
    tot += sum(old)
    old = new
print(tot)