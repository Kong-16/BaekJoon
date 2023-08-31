import sys

input = sys.stdin.readline

n = int(input().rstrip())

s = 1
e = 1
tot = 1
cnt = 0
while s <= n:
    if tot < n:
        e += 1
        tot += e
    elif n < tot:
        tot -= s
        s += 1
    else:
        cnt += 1
        tot -= s
        s += 1
print(cnt)