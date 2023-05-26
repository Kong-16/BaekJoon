import sys

input = sys.stdin.readline

sys.setrecursionlimit(10 ** 5)


def dfs(cur):
    for next in tree[cur]:
        compliment[next] += compliment[cur]
        dfs(next)


n, m = map(int, input().split())

tree = [[] for _ in range(n + 1)]
parent = list(map(int, input().split()))
parent.insert(0, 0)
compliment = [0 for _ in range(n + 1)]

for i in range(2, n + 1):
    tree[parent[i]].append(i)

for _ in range(m):
    i, w = map(int, input().split())
    compliment[i] += w

dfs(1)

for i in range(1, n + 1):
    print(compliment[i], end=" ")