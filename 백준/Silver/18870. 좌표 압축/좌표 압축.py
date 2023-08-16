import sys

input = sys.stdin.readline


def binarySearch(find, arr):
    s = 0
    e = n - 1
    idx = -1
    while s <= e:
        mid = (s + e) // 2
        if arr[mid] < find:
            idx = mid
            s = mid + 1
        else:
            e = mid - 1
    return idx


n = int(input().strip())

dots = list(map(int, input().split()))

sorted_dots = sorted(list(set(dots)))
n = len(sorted_dots)
for d in dots:
    right = binarySearch(d, sorted_dots)
    print(right + 1, end=" ")