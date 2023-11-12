import sys

input = sys.stdin.readline

n = 4
tot = 0
ans = 0
for _ in range(n):
    o, i = map(int, input().split())
    tot -= o
    tot += i
    ans = max(ans, tot)

print(ans)