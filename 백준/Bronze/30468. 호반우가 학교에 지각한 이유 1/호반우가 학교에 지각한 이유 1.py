import sys

input = sys.stdin.readline

arr = list(map(int, input().split()))

stat = sum(arr[:-1])
n = arr[-1]
gap = 4 * n - stat
print(gap if 0 < gap else 0)