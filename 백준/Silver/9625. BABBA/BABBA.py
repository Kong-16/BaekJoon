import sys

input = sys.stdin.readline

dp = [[0, 0] for _ in range(46)]

dp[0][0] = 1
k = int(input().rstrip())

for i in range(1, k + 1):
    dp[i][0] = dp[i - 1][1]
    dp[i][1] = dp[i - 1][1] + dp[i - 1][0]

print("{} {}".format(dp[k][0], dp[k][1]))