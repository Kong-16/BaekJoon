import sys

input = sys.stdin.readline

m = 12

dp = [[1,0,0] for _ in range(m)]

dp[2][0] = 1
dp[2][1] = 1

for i in range(3, m):
    for j in range(3):
        dp[i][j] = sum(dp[i-(j+1)])

t = int(input().rstrip())

for _ in range(t):
    print(sum(dp[int(input().rstrip())]))