import sys

input = sys.stdin.readline

l = int(input().rstrip())
a = int(input().rstrip())
b = int(input().rstrip())
c = int(input().rstrip())
d = int(input().rstrip())

workday = 0

while 0 < a or 0 < b:
    a -= c
    b -= d
    workday += 1
print(l - workday)