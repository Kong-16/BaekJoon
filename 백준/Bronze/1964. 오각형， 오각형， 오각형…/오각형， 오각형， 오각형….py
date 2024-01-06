import sys

input = sys.stdin.readline

n = int(input().rstrip())

dp = [0 for _ in range(n + 1)]

dp[1] = 5
for i in range(2, n + 1):
    dp[i] = dp[i - 1] + 3 * i + 1

print(dp[n] % 45678)