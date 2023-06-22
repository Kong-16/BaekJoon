import sys

input = sys.stdin.readline


def union(a, b):
    a = find_(a)
    b = find_(b)
    if a == b:
        return
    else:
        parent[b] = a


def find_(a):
    if parent[a] != a:
        parent[a] = find_(parent[a])
    return parent[a]


n, m = map(int, input().split())

parent = [i for i in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    union(a, b)

for i in range(1, n + 1):
    find_(i)

lecture = list(map(int, input().split()))

prev = parent[lecture[0]]
cnt = 0
for i in lecture:
    cur = parent[i]
    if prev != cur:
        cnt += 1
    prev = cur

print(cnt)