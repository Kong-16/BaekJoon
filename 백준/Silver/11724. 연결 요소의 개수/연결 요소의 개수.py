import sys

input = sys.stdin.readline


def find(a):
    if parent[a] == a:
        return a
    else:
        parent[a] = find(parent[a])
        return parent[a]


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
rank = [1 for _ in range(n + 1)]

for _ in range(m):
    a, b = list(map(int, input().split()))
    union_(a, b)
    
for i in range(n, 0, -1):
    find(i)
p_set = set()
for i in range(1, n + 1):
    p_set.add(parent[i])

print(len(p_set))