import sys
import collections

input = sys.stdin.readline


def bfs(cnt):
    while dq:
        size = len(dq)
        for _ in range(size):
            cur = dq.popleft()
            if cur == g - 1:
                return cnt
            if u:
                up = cur + u
                if up < f and arr[up]:
                    arr[up] = False
                    dq.append(up)
            if d:
                down = cur - d
                if 0 <= down and arr[down]:
                    arr[down] = False
                    dq.append(down)
        cnt += 1
    return -1


f, s, g, u, d = map(int, input().split())

arr = [True for _ in range(f)]

dq = collections.deque()
arr[s - 1] = False
dq.append(s - 1)
ans = bfs(0)

print("use the stairs" if ans == -1 else ans)