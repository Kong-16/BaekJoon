import sys

input = sys.stdin.readline

n, k = map(int, input().split())

dp = [0 for _ in range(k + 1)]
coins = [int(input().strip()) for _ in range(n)]

for coin in coins:
    for idx in range(1, k + 1):
        if idx == coin:
            dp[idx] += 1
        elif coin < idx:
            dp[idx] = dp[idx] + dp[idx - coin]
print(dp[k])