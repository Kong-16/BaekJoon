import sys

input = sys.stdin.readline

n, minimum, maximum, t, r = map(int, input().split())

cur = minimum
cnt = 0
prev = -1
time = 0

while cnt < n:
    if cur + t <= maximum:
        cnt += 1
        cur += t
    else:
        cur -= r
        if cur < minimum:
            cur = minimum
    if cur == prev:
        time = -1
        break
    prev = cur
    time += 1

print(time)