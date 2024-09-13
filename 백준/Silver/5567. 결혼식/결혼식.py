import sys
from collections import deque

input = sys.stdin.readline

n = int(input().rstrip())
m = int(input().rstrip())

graph = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

queue = deque()
queue.append(1)
visited[1] = True
cnt = 0

while queue and cnt < 2:
    size = len(queue)
    for _ in range(size):
        cur = queue.popleft()
        for n in graph[cur]:
            if not visited[n]:
                visited[n] = True
                queue.append(n)
    cnt += 1

print(visited.count(True) - 1)