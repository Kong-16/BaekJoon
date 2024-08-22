import sys

input = sys.stdin.readline

arr = list(map(int, input().split()))


def isSame(a):
    cmp = [1, 2, 3, 4, 5]
    for i in range(5):
        if a[i] != cmp[i]:
            return False
    return True


while not isSame(arr):
    for i in range(4):
        if arr[i + 1] < arr[i]:
            arr[i], arr[i + 1] = arr[i + 1], arr[i]
            print(*arr)