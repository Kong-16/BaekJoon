import sys
import collections

input = sys.stdin.readline

dq = collections.deque()

dq.append(0)
dq.append(1)

n = int(input().rstrip())
for i in range(2, n + 1):
    dq.append((dq.popleft() + dq[0]) % 1000000007)

if n == 0:
    print(0)
else:
    print(dq[1])