import sys
import collections

input = sys.stdin.readline

n, m, r = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(n + 1):
    graph[i].sort()

queue = collections.deque()
queue.append(r)

order = [0] * n
order[r - 1] = 1
cnt = 1

visited = [False] * (n + 1)
visited[r] = True

while queue:
    cur = queue.popleft()
    order[cur - 1] = cnt
    cnt += 1
    for n in graph[cur]:
        if not visited[n]:
            visited[n] = True
            queue.append(n)

for i in order:
    print(i)