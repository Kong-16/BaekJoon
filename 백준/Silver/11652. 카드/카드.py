import sys
import collections

input = sys.stdin.readline

n = int(input().rstrip())

arr = []
for _ in range(n):
    arr.append(int(input().rstrip()))

counter = collections.Counter(arr)
max_cnt = -1
max_num = -1

for k, v in counter.items():
    if max_cnt < v or (max_cnt == v and k < max_num):
        max_cnt = v
        max_num = k

print(max_num)