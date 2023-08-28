import sys
import heapq
from collections import deque

input = sys.stdin.readline

n = int(input().strip())
m = int(input().strip())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    f, t, w = map(int, input().split())
    graph[f].append([t, w])

s, e = map(int, input().split())
dist = [100000001 for _ in range(n + 1)]

q = []
heapq.heappush(q, [s, 0])
dist[s] = 0
while q:
    curNode, curWeight = heapq.heappop(q)
    if dist[curNode] < curWeight:
        continue
    for nextNode, nextWeight in graph[curNode]:
        if curWeight + nextWeight < dist[nextNode]:
            dist[nextNode] = curWeight + nextWeight
            heapq.heappush(q, [nextNode, dist[nextNode]])
print(dist[e])