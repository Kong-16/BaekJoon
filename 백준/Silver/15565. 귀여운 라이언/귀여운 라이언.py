import sys

input = sys.stdin.readline

n, k = map(int, input().split())

arr = list(map(int, input().split()))
lion = []
for i in range(n):
    if arr[i] == 1:
        lion.append(i)
length = len(lion)
ans = 1000007
if k <= length:
    cnt = 0
    s = 0
    e = k - 1
    while e < length:
        ans = min(ans, lion[e] - lion[s] + 1)
        s += 1
        e += 1

if ans == 1000007:
    ans = -1
print(ans)