import sys

input = sys.stdin.readline

n = 3

t = int(input().rstrip())

for _ in range(t):
    arr = sorted(list(map(int, input().split())))
    print(arr[7])