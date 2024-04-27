import sys

input = sys.stdin.readline

n, m = map(int, input().split())

if n == 0:
    print(0)
    exit(0)

books = list(map(int, input().split()))

cnt = 1
remain = m
for b in books:
    if b <= remain:
        remain -= b
    else:
        remain = m - b
        cnt += 1

print(cnt)