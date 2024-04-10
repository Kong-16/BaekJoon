import sys

input = sys.stdin.readline

n = int(input().rstrip())

cnt = 0
dp = [1 for _ in range(10)]

for i in range(1, n):
    for j in range(9, -1, -1):
        dp[j] = sum(dp[: j + 1])
print(sum(dp) % 10007)