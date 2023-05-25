import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    str = input()
    print(str[0] + str[-2])