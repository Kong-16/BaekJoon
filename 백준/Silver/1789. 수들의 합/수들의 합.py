import sys

input = sys.stdin.readline

s = int(input().rstrip()) * 2

num = 1
while (num + 1) * num <= s:
    num += 1

print(num - 1)