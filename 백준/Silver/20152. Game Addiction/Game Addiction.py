import sys

input = sys.stdin.readline


h, n = map(int, input().split())

d = abs(h - n) + 1

dp = [[0 for _ in range(d)] for _ in range(d)]

for i in range(d):
    dp[0][i] = 1
for i in range(1, d):
    for j in range(1, d):
        if i <= j:
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

print(dp[d - 1][d - 1])