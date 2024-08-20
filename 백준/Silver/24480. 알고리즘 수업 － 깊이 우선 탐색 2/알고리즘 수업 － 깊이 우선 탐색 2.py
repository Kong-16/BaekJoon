import sys

sys.setrecursionlimit(10**5)
input = sys.stdin.readline


def dfs(cur):
    global cnt
    for n in graph[cur]:
        if not visited[n]:
            visited[n] = cnt
            cnt += 1
            dfs(n)


n, m, r = map(int, input().split())

graph = [[] for _ in range(n)]
visited = [0 for _ in range(n)]
for _ in range(m):
    u, v = map(int, input().split())
    u -= 1
    v -= 1
    graph[u].append(v)
    graph[v].append(u)

for i in range(n):
    graph[i].sort(reverse=True)

visited[r - 1] = 1
cnt = 2
dfs(r - 1)
for i in visited:
    print(i)