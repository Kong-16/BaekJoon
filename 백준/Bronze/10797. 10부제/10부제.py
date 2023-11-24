import sys

input = sys.stdin.readline

n = int(input().rstrip())

cars = list(map(int, input().split()))

cnt = 0

for c in cars:
    if c == n:
        cnt += 1

print(cnt)