import sys

input = sys.stdin.readline

n = 9
arr = [list(map(int, input().split())) for _ in range(n)]

max_num = 0
ans = [0, 0]
for i in range(n):
    for j in range(n):
        if max_num < arr[i][j]:
            max_num = arr[i][j]
            ans = [i, j]

print(max_num)
print("{} {}".format(ans[0] + 1, ans[1] + 1))