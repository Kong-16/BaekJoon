import sys

input = sys.stdin.readline


def binarySearch(find, arr):
    s = 0
    e = len(arr) - 1
    idx = -1
    while s <= e:
        mid = (s + e) // 2
        if arr[mid] < find:
            s = mid + 1
        elif find < arr[mid]:
            e = mid - 1
        else:
            idx = mid
            e = mid - 1
    return idx


n, m = map(int, input().split())

arr = []
for _ in range(n):
    arr.append(int(input().rstrip()))
arr.sort()
for _ in range(m):
    find = int(input().rstrip())
    print(binarySearch(find, arr))