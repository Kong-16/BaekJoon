import sys
import heapq

input = sys.stdin.readline
INF = 2000000000


def dijkstra(start):
    dist = [INF for _ in range(n + 1)]
    dist[start] = 0
    pq = []
    heapq.heappush(pq, [0, start])
    while pq:
        weight, to = heapq.heappop(pq)
        if dist[to] < weight:
            continue
        for nextT, nextW in graph[to]:
            if weight + nextW < dist[nextT]:
                dist[nextT] = weight + nextW
                heapq.heappush(pq, [dist[nextT], nextT])
    return dist


n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    p, q, r = map(int, input().split())
    graph[p].append([q, r])
    graph[q].append([p, r])

cost = dijkstra(1)
print(cost[n])