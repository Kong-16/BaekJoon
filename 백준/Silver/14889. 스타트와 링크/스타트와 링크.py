import sys

input = sys.stdin.readline


def dfs(cur, idx):
    if cur == n // 2:
        s = 0
        l = 0
        global ans
        for i in range(n):
            for j in range(i + 1, n):
                if visited[i] and visited[j]:
                    s += matrix[i][j] + matrix[j][i]
                elif not visited[i] and not visited[j]:
                    l += matrix[i][j] + matrix[j][i]
        ans = min(ans, abs(s - l))
        return
    for i in range(idx, n):
        if not visited[i]:
            visited[i] = True
            dfs(cur + 1, i + 1)
            visited[i] = False


n = int(input().rstrip())

matrix = []
visited = [False for _ in range(n)]
ans = int(1e9)
for _ in range(n):
    matrix.append(list(map(int, input().split())))

dfs(0, 0)
print(ans)