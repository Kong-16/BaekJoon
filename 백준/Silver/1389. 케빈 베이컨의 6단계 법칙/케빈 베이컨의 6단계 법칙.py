import sys
import collections

input = sys.stdin.readline
INF = 10e9


def bfs(start):
    dist = [INF for _ in range(n + 1)]
    dist[start] = 0
    deque = collections.deque()
    deque.append([start, 0])
    while deque:
        size = len(deque)
        for _ in range(size):
            # 현재 위치와 거리
            cur, cost = deque.popleft()
            # cur위치에서 갈 수 있는 모든 노드 방문
            for next in graph[cur]:
                # 방문하지 않았으면,
                if dist[next] == INF:
                    # next와 start의 거리 = cur과의  + 1
                    dist[next] = cost + 1
                    deque.append([next, dist[next]])
    # dist[0] 이 INF이므로 빼줌.
    return sum(dist) - INF


n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]
kbn = [0 for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

minNum = INF
minIdx = 0

# 모든 사람에 대해 케빈베이컨수의 합 구하고 최솟값과 index 저장.
for i in range(1, n + 1):
    tmp = bfs(i)
    if (tmp < minNum):
        minNum = tmp
        minIdx = i

print(minIdx)