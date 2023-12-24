import sys
import heapq

input = sys.stdin.readline

n = int(input().rstrip())
arr = []
dasom = int(input().rstrip())
cnt = 0
for _ in range(n - 1):
    heapq.heappush(arr, -int(input().rstrip()))

while arr:
    tmp = -heapq.heappop(arr)
    if dasom <= tmp:
        heapq.heappush(arr, -(tmp - 1))
        dasom += 1
        cnt += 1
    else:
        break
print(cnt)