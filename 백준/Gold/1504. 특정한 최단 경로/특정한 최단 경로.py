import heapq
import sys
import collections

input = sys.stdin.readline
INF = 200000002


def dijkstra(start, end):
    pq = []
    heapq.heappush(pq, [start, 0])
    dist = [INF for _ in range(n + 1)]
    dist[start] = 0
    while pq:
        t, w = heapq.heappop(pq)
        for [nt, nw] in graph[t]:
            if w + nw < dist[nt]:
                dist[nt] = w + nw
                heapq.heappush(pq, [nt, dist[nt]])
    return dist[end]


n, e = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

a, b = map(int, input().split())
ans = min(dijkstra(1, a) + dijkstra(a, b) + dijkstra(b, n), dijkstra(1, b) + dijkstra(b, a) + dijkstra(a, n))
print(ans if ans < INF else -1)