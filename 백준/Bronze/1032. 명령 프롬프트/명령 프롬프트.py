import sys

input = sys.stdin.readline
n = int(input().rstrip())

str_arr = []

for _ in range(n):
    str_arr.append(input().rstrip())

length = len(str_arr[0])
ans = ""

for c in range(length):
    std_c = str_arr[0][c]
    for i in range(1, n):
        if str_arr[i][c] != std_c:
            ans += "?"
            break
    if len(ans) <= c:
        ans += std_c

print(ans)