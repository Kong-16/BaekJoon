import sys

input = sys.stdin.readline


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    parent[a] = b
    return True


n, m = map(int, input().split())

graph = []
parent = [i for i in range(n + 1)]
for _ in range(m):
    f, t, w = map(int, input().split())
    graph.append([f, t, w])

graph.sort(key=lambda x: x[2])

ans = 0
maxW = 0
for f, t, w in graph:
    if union(f, t):
        maxW = max(maxW, w)
        ans += w
ans -= maxW

print(ans)