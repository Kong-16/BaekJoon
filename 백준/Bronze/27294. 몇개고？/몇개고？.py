import sys

input = sys.stdin.readline

t,s = map(int,input().split())

if 12 <= t and t <=16 and not s:
    print(320)
else:
    print(280)