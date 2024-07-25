import sys

input = sys.stdin.readline

n, k = map(int, input().split())

arr = [i + 1 for i in range(n)]

ans = []
cnt = 0
it = 0
while arr:
    cnt += 1
    if cnt == k:
        ans.append(arr.pop(it))
        cnt = 0
        continue
    it += 1
    it = it % len(arr)

print("<", end="")
print(*ans, sep=", ", end="")
print(">", end="")