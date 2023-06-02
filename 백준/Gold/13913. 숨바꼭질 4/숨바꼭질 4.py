import sys
import collections

input = sys.stdin.readline

MAX = 200002

visited = [False for _ in range(MAX)]
prev = [-1 for _ in range(MAX)]


def inRange(cur):
    return 0 <= cur and cur < MAX


n, k = map(int, input().split())

deque = collections.deque()

deque.append(n)
visited[n] = True

while deque:
    size = len(deque)
    cur = deque.popleft()
    if cur == k:
        break
    # 누나가 갈 수 있는 경로
    next = [cur - 1, cur + 1, cur * 2]
    for n in next:
        # 범위 안에 있고 아직 방문하지 않았다면,
        if inRange(n) and not visited[n]:
            visited[n] = True
            deque.append(n)
            # 이전 경로 저장
            prev[n] = cur

path = collections.deque()
while -1 < k:
    path.append(k)
    # 이전의 위치로 이동 하며 루트 저장
    k = prev[k]

print(len(path) - 1)
while path:
    print(path.pop(), end=" ")