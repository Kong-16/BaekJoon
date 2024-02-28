import sys
import collections

input = sys.stdin.readline

n, k = map(int, input().split())

ans = 1
for i in range(k):
    ans *= n - i
    ans //= i + 1

print(ans)