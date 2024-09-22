import sys

input = sys.stdin.readline

arr = list(map(int, input().split()))

tot = 0

for i in range(3):
    d = arr[i] // 3
    arr[i] %= 3
    tot += d
arr.sort(reverse=True)
if 1 <= sum(arr):
    if (arr[0] <= 1 and arr[1] <= 1 and arr[2] <= 1) or (arr[0] == 2 and arr[1] == 0):
        tot += 1
    else:
        tot += 2
print(tot)