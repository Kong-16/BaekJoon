import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**5)


def dfs(r):
    global cnt
    visited[r] = cnt
    cnt += 1
    for next in graph[r]:
        if not visited[next]:
            dfs(next)


n, m, r = map(int, input().split())

graph = [[] for _ in range(n + 1)]
visited = [0 for _ in range(n + 1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(n + 1):
    graph[i].sort()
cnt = 1
dfs(r)

visited.pop(0)

for i in visited:
    print(i)