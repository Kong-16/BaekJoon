import sys

input = sys.stdin.readline

n = int(input().rstrip())


def isDec(arr):
    for i in range(n - 1):
        if arr[i] < arr[i + 1]:
            return False
    return True


def isInc(arr):
    for i in range(n - 1):
        if arr[i + 1] < arr[i]:
            return False
    return True


a = []

for _ in range(n):
    a.append(input().rstrip())

if isDec(a):
    print("DECREASING")
elif isInc(a):
    print("INCREASING")
else:
    print("NEITHER")