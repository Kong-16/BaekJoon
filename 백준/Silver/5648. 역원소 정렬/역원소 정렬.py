import sys

input = sys.stdin.readline

arr = []

tmp = list(map(int, input().split()))

n = tmp[0]

arr.extend(map(str, tmp[1:]))
while len(arr) < n:
    arr.extend(input().split())

rev = []

for c in arr:
    rev.append(int(c[::-1]))

rev.sort()
print(*rev, sep="\n")