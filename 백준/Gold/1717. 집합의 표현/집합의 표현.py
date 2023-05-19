import sys

input = sys.stdin.readline


def find(a):
    if parent[a] == a:
        return a
    else:
        return find(parent[a])


def union_(a, b):
    a = find(a)
    b = find(b)
    if rank[a] < rank[b]:
        parent[a] = b
    elif rank[b] < rank[a]:
        parent[b] = a
    else:
        parent[a] = b
        rank[b] += 1


n, m = list(map(int, input().split()))

parent = [i for i in range(n + 1)]
rank = [1 for i in range(n + 1)]

for _ in range(m):
    cmd, a, b = list(map(int, input().split()))
    if (cmd == 0):
        union_(a, b)
    else:
        if (find(a) == find(b)):
            print("yes")
        else:
            print("no")