import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = sorted(list(map(int, input().split())))

ans = -1

tot = sum(arr)
m = tot
for i in arr:
    s = 0
    for j in arr:
        s += abs(j - i)
    if s < m:
        ans = i
        m = s

print(ans)