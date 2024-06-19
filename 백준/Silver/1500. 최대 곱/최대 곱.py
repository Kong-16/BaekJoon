import sys

input = sys.stdin.readline

s, k = map(int, input().split())

d = s // k
r = s % k

ans = 1

for i in range(r):
    ans *= d + 1
for i in range(k - r):
    ans *= d
print(ans)
