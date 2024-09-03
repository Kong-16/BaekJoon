import sys

input = sys.stdin.readline


def inRange(cur_x, cur_y):
    return 0 <= cur_x and cur_x < x and 0 <= cur_y and cur_y < y


def horiz(cur_x, cur_y):
    while inRange(cur_x, cur_y) and board[cur_x][cur_y] == "-":
        visited[cur_x][cur_y] = True
        cur_y += 1


def vert(cur_x, cur_y):
    while inRange(cur_x, cur_y) and board[cur_x][cur_y] == "|":
        visited[cur_x][cur_y] = True
        cur_x += 1


x, y = map(int, input().split())

visited = [[False for _ in range(y)] for _ in range(x)]
board = []
for _ in range(x):
    board.append(input().rstrip())

ans = 0
for i in range(x):
    for j in range(y):
        if not visited[i][j]:
            if board[i][j] == "-":
                ans += 1
                horiz(i, j)
            elif board[i][j] == "|":
                ans += 1
                vert(i, j)

print(ans)