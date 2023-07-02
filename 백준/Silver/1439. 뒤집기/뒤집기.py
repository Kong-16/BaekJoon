import sys

input = sys.stdin.readline

n = input()

cnt = [0, 0]
prev = n[0]
for i in n:
    if i != prev:
        cnt[int(prev)] += 1
    prev = i
print(min(cnt))