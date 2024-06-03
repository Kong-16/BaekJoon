import sys

input = sys.stdin.readline

m = 1000

coins = [500, 100, 50, 10, 5, 1]

n = int(input().rstrip())

cnt = 0
m -= n
for c in coins:
    cnt += m // c
    m %= c

print(cnt)