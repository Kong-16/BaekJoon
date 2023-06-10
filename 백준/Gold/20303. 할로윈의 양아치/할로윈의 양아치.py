import sys

sys.setrecursionlimit(10 ** 5)


def find(a):
    if a == parent[a]:
        return a
    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)
    parent[a] = b


input = sys.stdin.readline

n, m, k = map(int, input().split())

parent = [i for i in range(n + 1)]
candy = list(map(int, input().split()))
candy.insert(0, 0)

for _ in range(m):
    a, b = map(int, input().split())
    union(a, b)

for i in range(1, n + 1):
    find(i)

group = dict()
for i in range(1, n + 1):
    group[parent[i]] = [x + y for x, y in zip(group.get(parent[i], [0, 0]), [1, candy[i]])]

weight = [0]
value = [0]

for num, c in group.values():
    weight.append(num)
    value.append(c)

size = len(weight)
dp = [[0 for _ in range(k)] for _ in range(size)]

for i in range(1, size):
    for j in range(1, k):
        if weight[i] <= j:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
        else:
            dp[i][j] = dp[i - 1][j]

print(dp[-1][-1])