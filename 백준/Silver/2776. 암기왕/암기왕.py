import sys

input = sys.stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    s = set(map(int, input().split()))
    m = int(input().rstrip())
    arr = list(map(int, input().split()))
    for i in arr:
        print(int(i in s))