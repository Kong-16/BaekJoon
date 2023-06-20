import sys
from collections import deque

input = sys.stdin.readline
n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]

for _ in range(m):
    f, t = map(int, input().split())
    graph[f].append(t)

dq = deque()
# 시작점
dq.append(x)
visited[x] = True
dist = 0
while dq:
    size = len(dq)
    for _ in range(size):
        cur = dq.popleft()
        for next in graph[cur]:
            if not visited[next]:
                visited[next] = True
                dq.append(next)
    dist += 1
    if dist == k:
        break

city = []
while dq:
    city.append(dq.popleft())

city.sort()

if city:
    for c in city:
        print(c)
else:
    print(-1)