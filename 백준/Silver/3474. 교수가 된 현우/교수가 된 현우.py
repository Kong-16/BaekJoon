import sys

input = sys.stdin.readline

t = int(input().rstrip())

m = 1000000001

for _ in range(t):
    n = int(input().rstrip())
    cnt = 0
    i = 5
    while i <= n:
        cnt += n // i
        i *= 5 
    print(cnt)