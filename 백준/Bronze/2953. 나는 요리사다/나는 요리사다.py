import sys

input = sys.stdin.readline

arr = [0 for _ in range(5)]
max_sum = 0
ans = -1
for i in range(5):
    arr[i] = sum(list(map(int, input().split())))
    if max_sum < arr[i]:
        max_sum = arr[i]
        ans = i

print("{} {}".format(ans + 1, max_sum))