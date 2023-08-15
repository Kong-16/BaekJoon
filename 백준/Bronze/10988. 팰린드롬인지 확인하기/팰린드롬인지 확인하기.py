import sys

input = sys.stdin.readline

inp = input().strip()

s = 0
e = len(inp) - 1

flag = 1

while s <= e:
    if inp[s] != inp[e]:
        flag = 0
        break
    s += 1
    e -= 1
print(flag)