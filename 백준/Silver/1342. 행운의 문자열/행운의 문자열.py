import sys

sys.setrecursionlimit(10**5)
input = sys.stdin.readline


def check(a):
    s = "Z"
    for i in a:
        if s == i:
            return False
        s = i
    return True


def dfs(arr, cur):
    if cur == n and check(arr):
        s.add(arr)
        return
    for i in range(n):
        if not visited[i]:
            arr += inp[i]
            visited[i] = True
            dfs(arr, cur + 1)
            arr = arr[:-1]
            visited[i] = False


inp = input().rstrip()
n = len(inp)
visited = [False for _ in range(n)]
s = set()


dfs("", 0)
print(len(s))