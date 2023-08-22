import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[[], 0] for _ in range(n + 1)]

for _ in range(m):
    t, s = map(int, input().split())
    graph[t][0].append(s)
    graph[s][1] += 1

q = deque()
ans = deque()
for i in range(1, len(graph)):
    if graph[i][1] == 0:
        q.append(i)
while q:
    cur = q.popleft()
    ans.append(cur)
    for n in graph[cur][0]:
        graph[n][1] -= 1
        if graph[n][1] == 0:
            q.append(n)

print(*ans)