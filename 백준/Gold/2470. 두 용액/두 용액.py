import sys

input = sys.stdin.readline

n = int(input().rstrip())

liquid = sorted(list(map(int, input().split())))

gap = 2000000001

s = 0
e = len(liquid) - 1

ans = [0, 0]
while s < e:
    small = liquid[s]
    big = liquid[e]
    tot = small + big
    if abs(tot) < gap:
        gap = abs(tot)
        ans = [small, big]
    if 0 < tot:
        e -= 1
    else:
        s += 1
print(*ans)