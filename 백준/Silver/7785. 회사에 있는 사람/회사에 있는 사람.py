import sys

input = sys.stdin.readline

n = int(input().rstrip())
arr = []

for i in range(n):
    o, s = input().split()
    if s == "enter":
        arr.append(o)
    else:
        arr.remove(o)

arr.sort(reverse=True)

for i in arr:
    print(i)