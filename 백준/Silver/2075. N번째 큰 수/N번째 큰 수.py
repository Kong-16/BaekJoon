import sys
import heapq

input = sys.stdin.readline

n = int(input().rstrip())

pq = []

for _ in range(n):
    arr = list(map(int, input().split()))
    for i in arr:
        if len(pq) < n:
            heapq.heappush(pq, i)
        else:
            num = heapq.heappop(pq)
            if num < i:
                heapq.heappush(pq, i)
            else:
                heapq.heappush(pq, num)

print(heapq.heappop(pq))