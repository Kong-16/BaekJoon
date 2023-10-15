import sys

input = sys.stdin.readline

n, m = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]

arr.insert(0, [0 for _ in range(m + 1)])
for i in range(1, n + 1):
    arr[i].insert(0, 0)

prefix = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, m + 1):
        prefix[i][j] = arr[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1]

k = int(input().rstrip())
for _ in range(k):
    i, j, x, y = map(int, input().split())
    print(prefix[x][y] - prefix[i - 1][y] - prefix[x][j - 1] + prefix[i - 1][j - 1])