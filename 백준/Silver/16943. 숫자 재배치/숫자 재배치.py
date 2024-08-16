import sys

input = sys.stdin.readline


def dfs(arr, cur):
    if cur == n and arr[0] != "0":
        num = int("".join(arr))
        if num < b:
            global ans
            ans = max(ans, num)
        return
    for i in range(n):
        if not visited[i]:
            arr.append(a[i])
            visited[i] = True
            dfs(arr, cur + 1)
            arr.pop()
            visited[i] = False


a, b = input().split()

b = int(b)
n = len(a)

visited = [False for _ in range(n)]
ans = -1
dfs([], 0)
print(ans)