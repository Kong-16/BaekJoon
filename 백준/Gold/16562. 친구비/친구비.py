import sys

input = sys.stdin.readline


def find(a):
    if (parent[a] == a):
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
        parent[b] = a
        rank[a] += 1
    if fee[a] < fee[b]:
        fee[b] = fee[a]
    else:
        fee[a] = fee[b]


n, m, k = map(int, input().split())

parent = [i for i in range(n + 1)]
rank = [1 for i in range(n + 1)]
fee = list(map(int, input().split()))
fee.insert(0, 0)

for _ in range(m):
    v, w = map(int, input().split())
    union_(v, w)

my_set = set()
for i in range(1, n + 1):
    find(i)

for i in range(1, n + 1):
    my_set.add(parent[i])

total = 0
for i in my_set:
    total += fee[i]

if total <= k:
    print(total)
else:
    print("Oh no")