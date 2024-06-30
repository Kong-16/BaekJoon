import sys

input = sys.stdin.readline

n = int(input().rstrip())

ans = 0
for _ in range(n):
    c, k = map(int, input().split())
    ans += c * k

print(ans)