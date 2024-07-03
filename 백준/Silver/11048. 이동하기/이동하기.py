import sys
import collections

input = sys.stdin.readline


def inRange(x, y):
    return 0 <= x and x < n and 0 <= y and y < m


dir = [[1, 0], [0, 1]]

n, m = map(int, input().split())

board = []
dp = [[0 for _ in range(m)] for _ in range(n)]

for _ in range(n):
    board.append(list(map(int, input().split())))

dp[0][0] = board[0][0]
for x in range(n):
    for y in range(m):
        if inRange(x - 1, y):
            dp[x][y] = max(dp[x][y], dp[x - 1][y] + board[x][y])
        if inRange(x, y - 1):
            dp[x][y] = max(dp[x][y], dp[x][y - 1] + board[x][y])
print(dp[n - 1][m - 1])