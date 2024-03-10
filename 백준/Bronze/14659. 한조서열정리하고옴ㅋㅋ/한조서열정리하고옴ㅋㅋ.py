import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = map(int, input().split())

ans = 0
cnt = 0
height = -1
for i in arr:
    if i < height:
        cnt += 1
        ans = max(cnt, ans)
    elif height < i:
        cnt = 0
        height = i
print(ans)