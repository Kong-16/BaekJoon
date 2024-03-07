import sys
import collections

input = sys.stdin.readline

a, b = map(int, input().split())
queue = collections.deque()

queue.append(a)


def bfs():
    cnt = 1
    while queue:
        size = len(queue)
        for _ in range(size):
            cur = queue.popleft()
            if b < cur:
                continue
            if cur == b:
                queue.append(a)
                print(cnt)
                return
            else:
                queue.append(cur * 2)
                queue.append(cur * 10 + 1)
        cnt += 1


bfs()
if not queue:
    print(-1)