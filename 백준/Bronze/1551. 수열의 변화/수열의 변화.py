import sys

input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split(",")))

for i in range(k):
    tmp = []
    for j in range(n - i - 1):
        tmp.append(arr[j + 1] - arr[j])
    arr = tmp.copy()

print(",".join(map(str, arr)))