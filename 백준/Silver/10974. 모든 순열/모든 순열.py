import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**5)

arr = []


def dfs(cur):
    if cur == n:
        print(*arr)
        return
    for i in range(1, n + 1):
        if i not in arr:
            arr.append(i)
            dfs(cur + 1)
            arr.pop()


n = int(input().rstrip())

dfs(0)