import sys
import collections

input = sys.stdin.readline


def solve(n):
    parent = [-1 for i in range(n + 1)]
    tree = [[] for _ in range(n + 1)]
    # 트리를 연결해줌.
    for _ in range(n - 1):
        a, b = map(int, input().split())
        tree[a].append(b)
        tree[b].append(a)
        # 부모 노드
        parent[b] = a
    # 연결할 두 노드
    a, b = map(int, input().split())
    pathA = findWay(a, parent)
    pathB = findWay(b, parent)
    while 0 < len(pathB) and 0 < len(pathA):
        cur = pathA.pop()
        if cur != pathB.pop():
            break
        prev = cur
    print(prev)


def findWay(n, parent):
    path = collections.deque()
    while n != -1:
        path.append(n)
        n = parent[n]
    return path


test_case = int(input())

for _ in range(test_case):
    n = int(input())
    solve(n)