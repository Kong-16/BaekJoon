import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = list(map(int, input().split()))[::-1]

m = 0

res = 0
for i in arr:
    if i <= m:
        res += m - i
    else:
        m = i

print(res)