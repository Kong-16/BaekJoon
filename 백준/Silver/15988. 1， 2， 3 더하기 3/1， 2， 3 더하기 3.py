import sys

input = sys.stdin.readline

n = 1000002
dp = [[0, 0, 0] for _ in range(n)]

dp[1][0] = 1
dp[2][0] = 1
dp[2][1] = 1
dp[3][0] = 2
dp[3][1] = 1
dp[3][2] = 1

for i in range(4, n):
    for j in range(3):
        dp[i][j] = sum(dp[i - j - 1]) % 1000000009

t = int(input().rstrip())
for _ in range(t):
    num = int(input().rstrip())
    print(sum(dp[num])% 1000000009)