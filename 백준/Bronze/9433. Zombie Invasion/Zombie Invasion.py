import sys

n = int(input().rstrip())

for _ in range(n):
    arr = list(map(int, input().split()))
    for i in range(len(arr) - 1, 0, -1):
        arr[i - 1] += arr[i] // 2
        arr[i] %= 2
    print(*arr)