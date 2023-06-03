import sys
import collections

input = sys.stdin.readline

MAX = 200002

# time[i] = i위치에 올 때까지 걸린 시간
time = [MAX for _ in range(MAX)]


def inRange(cur):
    return 0 <= cur and cur < MAX


n, k = map(int, input().split())

deque = collections.deque()

deque.append(n)

time[n] = 0

cnt = 0

while deque:
    cur = deque.popleft()
    # 누나가 갈 수 있는 경로
    next = [cur - 1, cur + 1, cur * 2]
    if cur == k:
        cnt += 1
    for n in next:
        # 범위 안에 있고 가는 시간이 time[n]과 작거나 같을 경우
        if inRange(n) and time[cur] + 1 <= time[n]:
            time[n] = time[cur] + 1
            deque.append(n)

print(time[k])
print(cnt)