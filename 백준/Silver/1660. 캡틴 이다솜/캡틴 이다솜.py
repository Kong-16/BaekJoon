import sys

input = sys.stdin.readline


n = int(input().rstrip())

tri = [0]
dp = [1000 for _ in range(n + 1)]

i = 1
j = 1
k = 1
while tri[-1] < n:
    tri.append(k)
    i += 1
    j += i
    k += j


# dp[i] : i로 만들 수 있는 최소 사면체
dp[0] = 0
for i in range(n + 1):
    for num in tri:
        if 0 <= i - num:
            dp[i] = min(dp[i], 1 + dp[i - num])

print(dp[n])