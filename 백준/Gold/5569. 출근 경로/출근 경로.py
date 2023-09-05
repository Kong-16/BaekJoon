import sys

input = sys.stdin.readline

n, m = map(int, input().split())

# 3차원 0 : 이전과 이동방향 같음 1 : 이전과 이동방향 다름
# 4차원 0 : 횡방향 도착 1 : 종방향 도착
dp = [[[[0, 0], [0, 0]] for _ in range(n + 1)] for _ in range(m + 1)]

for i in range(n + 1):
    dp[1][i][0][0] = 1
for i in range(m + 1):
    dp[i][1][0][1] = 1

for i in range(2, m + 1):
    for j in range(2, n + 1):
        dp[i][j][0][0] = dp[i][j - 1][0][0] + dp[i][j - 1][1][0]
        dp[i][j][0][1] = dp[i - 1][j][0][1] + dp[i - 1][j][1][1]
        dp[i][j][1][0] = dp[i][j - 1][0][1]
        dp[i][j][1][1] = dp[i - 1][j][0][0]

print((dp[m][n][0][0] + dp[m][n][0][1] + dp[m][n][1][0] + dp[m][n][1][1]) % 100000)