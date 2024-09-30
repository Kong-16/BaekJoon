import sys

input = sys.stdin.readline

m = 250

dp = [0 for _ in range(m + 1)]
dp[0] = 1
dp[1] = 1
dp[2] = 3
for i in range(3, m + 1):
    dp[i] = dp[i - 1] + 2 * (dp[i - 2])


while True:
    try:
        n = int(input().rstrip())
        print(dp[n])
    except:
        break