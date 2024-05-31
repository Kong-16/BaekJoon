import sys
import collections

input = sys.stdin.readline


def inRange(x, y):
    return 0 <= x and x < n and 0 <= y and y < m


def bfs(x, y):
    queue = collections.deque()
    cnt = 0
    board[x][y] = False
    queue.append((x, y))
    while queue:
        cur_x, cur_y = queue.popleft()
        cnt += 1
        for dir_x, dir_y in dir:
            next_x = cur_x + dir_x
            next_y = cur_y + dir_y
            if inRange(next_x, next_y) and board[next_x][next_y]:
                queue.append((next_x, next_y))
                board[next_x][next_y] = False
    return cnt


dir = [[0, 1], [-1, 0], [0, -1], [1, 0]]

n, m, k = map(int, input().split())

board = [[False for _ in range(m)] for _ in range(n)]

for _ in range(k):
    r, c = map(int, input().split())
    board[r - 1][c - 1] = True

ans = 0
for i in range(n):
    for j in range(m):
        if board[i][j]:
            ans = max(ans, bfs(i, j))
print(ans)