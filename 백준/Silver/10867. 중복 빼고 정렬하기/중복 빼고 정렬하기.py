import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = sorted(list(map(int, input().split())))

prev = -10000
for num in arr:
    if num != prev:
        print(num, end=" ")
        prev = num