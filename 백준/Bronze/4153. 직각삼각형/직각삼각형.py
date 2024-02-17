import sys

input = sys.stdin.readline

while True:
    arr = sorted(list(map(int, input().split())))
    if sum(arr) == 0:
        break
    if arr[0] ** 2 + arr[1] ** 2 == arr[2] ** 2:
        print("right")
    else:
        print("wrong")