import sys

input = sys.stdin.readline

ans = 1

n = int(input().rstrip())
for i in range(2, n + 1):
    ans *= i

print(ans)