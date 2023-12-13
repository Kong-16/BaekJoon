import sys

input = sys.stdin.readline

arr = list(map(int, input().split()))

cnt = 0
while arr[0] + 2 != arr[2]:
    if arr[1] - arr[0] < arr[2] - arr[1]:
        arr[0] = arr[1]
        arr[1] = arr[2] - 1
    else:
        arr[2] = arr[1]
        arr[1] = arr[0] + 1
    cnt += 1
print(cnt)