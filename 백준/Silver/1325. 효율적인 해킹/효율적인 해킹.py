import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    queue = deque()
    queue.append(start)
    visited = [False for _ in range(n + 1)]
    visited[start] = True
    cnt = 1
    while queue:
        c = queue.popleft()
        for next in graph[c]:
            if not visited[next]:
                visited[next] = True
                queue.append(next)
                cnt += 1
    return cnt


n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)

result = [0]
for i in range(1, n + 1):
    result.append(bfs(i))

max_cnt = max(result)
for i in range(1, n + 1):
    if result[i] == max_cnt:
        print(i, end=" ")