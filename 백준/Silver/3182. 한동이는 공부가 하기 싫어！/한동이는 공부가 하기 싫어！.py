import sys

input = sys.stdin.readline


def dfs(cur):
    visited[cur] = True
    if not visited[par[cur]]:
        dfs(par[cur])


n = int(input().rstrip())

par = [i for i in range(n + 1)]
result = []

for i in range(1, n + 1):
    par[i] = int(input().rstrip())

for i in range(1, n + 1):
    visited = [False for _ in range(n + 1)]
    visited[i] = True
    dfs(i)
    result.append(visited.count(True))

print(result.index(max(result)) + 1)