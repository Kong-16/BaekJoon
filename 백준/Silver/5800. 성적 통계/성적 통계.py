import sys

input = sys.stdin.readline

n = int(input().rstrip())

for i in range(n):
    num, *arr = map(int, input().split())
    arr.sort()
    M = arr[-1]
    m = arr[0]
    g = 0
    for j in range(num - 1):
        if g < arr[j + 1] - arr[j]:
            g = arr[j + 1] - arr[j]
    print("Class {}".format(i + 1))
    print("Max {}, Min {}, Largest gap {}".format(M, m, g))