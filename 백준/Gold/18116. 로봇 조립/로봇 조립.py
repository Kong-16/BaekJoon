import sys

input = sys.stdin.readline

sys.setrecursionlimit(10 ** 6)

parent = [i for i in range(10 ** 6 + 1)]
rank = [1 for i in range(10 ** 6 + 1)]
size = [1 for i in range(10 ** 6 + 1)]
ans = []


def find(a):
    if parent[a] == a:
        return a
    else:
        return find(parent[a])


def union_(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return;

    if rank[a] < rank[b]:
        parent[a] = b
        size[b] += size[a]
    elif rank[b] < rank[a]:
        parent[b] = a
        size[a] += size[b]
    else:
        parent[b] = a
        size[a] += size[b]
        rank[a] += 1


n = int(input())
for _ in range(n):
    inp = input().split()
    if inp[0] == "I":
        union_(int(inp[1]), int(inp[2]))
    elif inp[0] == "Q":
        ans.append(size[find(int(inp[1]))])

for i in ans:
    print(i)