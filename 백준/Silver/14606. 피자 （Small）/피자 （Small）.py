import sys

input = sys.stdin.readline

n = int(input().strip())

dp = [1 for _ in range(n + 1)]
dp[1] = 0
for i in range(3, n + 1):
    a = i // 2
    b = i - a
    dp[i] = dp[a] + dp[b] + a * b

print(dp[n])