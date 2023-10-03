import sys

input = sys.stdin.readline

n = int(input().rstrip())

health = list(map(int, input().split()))
happiness = list(map(int, input().split()))
health.insert(0, 0)
happiness.insert(0, 0)

dp = [[0 for _ in range(101)] for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, 101):
        if health[i] < j:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - health[i]] + happiness[i])
        else:
            dp[i][j] = dp[i - 1][j]
print(dp[n][100])