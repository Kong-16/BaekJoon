import sys

input = sys.stdin.readline

n = int(input().rstrip())

for _ in range(n):
    s, p = input().split()
    cnt = 0
    while p in s:
        s = s.replace(p, "", 1)
        cnt += 1
    cnt += len(s)
    print(cnt)