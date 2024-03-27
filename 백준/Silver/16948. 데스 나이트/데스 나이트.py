import sys
import collections

input = sys.stdin.readline


def isIn(r, c):
    return 0 <= r and r < n and 0 <= c and c < n


n = int(input().rstrip())

move = [[-2, -1], [-2, 1], [0, -2], [0, 2], [2, -1], [2, 1]]
board = [[0 for _ in range(n)] for _ in range(n)]

r1, c1, r2, c2 = map(int, input().split())

dq = collections.deque()
dq.append([r1, c1])
cnt = 1
while dq:
    size = len(dq)
    for _ in range(size):
        curR, curC = dq.popleft()
        for r, c in move:
            nextR = curR + r
            nextC = curC + c
            if isIn(nextR, nextC) and board[nextR][nextC] == 0:
                board[nextR][nextC] = cnt
                dq.append([nextR, nextC])
    cnt += 1

print(board[r2][c2] if board[r2][c2] else -1)