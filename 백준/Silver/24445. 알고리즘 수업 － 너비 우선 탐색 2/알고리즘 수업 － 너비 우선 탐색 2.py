import sys
import collections

input = sys.stdin.readline


n, m, r = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    f, t = map(int, input().split())
    graph[f].append(t)
    graph[t].append(f)

for i in range(n + 1):
    graph[i].sort(reverse=True)

visited = [0 for _ in range(n + 1)]
queue = collections.deque()

visited[r] = 1
queue.append(r)
level = 2

while queue:
    cur = queue.popleft()
    for n in graph[cur]:
        if not visited[n]:
            visited[n] = level
            level += 1
            queue.append(n)

visited.pop(0)
for i in visited:
    print(i)