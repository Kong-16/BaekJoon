import sys
import collections

input = sys.stdin.readline

arr = list(map(int, input().split()))

sums = collections.defaultdict(int)
for i in range(1, arr[0] + 1):
    for j in range(1, arr[1] + 1):
        for k in range(1, arr[2] + 1):
            if not sums[i + j + k]:
                sums[i + j + k] = 1
            else:
                sums[i + j + k] += 1

max_num = -1
ans = -1
for k, v in sums.items():
    if max_num < v:
        max_num = v
        ans = k

print(ans)