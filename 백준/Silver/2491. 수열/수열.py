import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = list(map(int, input().split()))

max_num = -1
min_num = 10
cnt = 0
max_cnt = 0

for num in arr:
    if max_num <= num:
        cnt += 1
        max_cnt = max(max_cnt, cnt)
    else:
        cnt = 1
    max_num = num

cnt = 0
for num in arr:
    if num <= min_num:
        cnt += 1
        max_cnt = max(max_cnt, cnt)
    else:
        cnt = 1
    min_num = num
print(max_cnt)