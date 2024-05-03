import sys
import collections

input = sys.stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n, m = map(int, input().split())
    inp = list(map(int, input().split()))
    queue = collections.deque()

    for i in range(len(inp)):
        queue.append([inp[i], i])

    s_queue = collections.deque(sorted(inp))
    num = queue[m][1]
    cnt = 0

    while queue:
        if queue[0][0] == s_queue[-1]:
            cnt += 1
            if queue.popleft()[1] == num:
                print(cnt)
                break
            s_queue.pop()
        else:
            queue.append(queue.popleft())