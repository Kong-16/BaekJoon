import sys

input = sys.stdin.readline

sys.setrecursionlimit(10 ** 5)


def dfs(cur, prev):
    global maxDiameter
    diameter = [0, 0]
    maxLength = 0
    curDiameter = 0
    for (t, w) in tree[cur]:
        if (t != prev):
            # 갈 수 있는 경로의 거리
            diameter.append(dfs(t, cur) + w)
    diameter.sort()
    for i in range(1, 3):
        curDiameter = curDiameter + diameter[-i]

    maxLength = max(diameter)
    maxDiameter = max(maxDiameter, curDiameter)
    return maxLength


n = int(input())
maxDiameter = 0
tree = [[] for _ in range(n + 1)]
dist = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    (f, t, w) = list(map(int, input().split()))
    tree[f].append([t, w])
    tree[t].append([f, 0])

dfs(1, 0)
print(maxDiameter)