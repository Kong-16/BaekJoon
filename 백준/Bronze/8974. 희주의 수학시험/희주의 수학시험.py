import sys

input = sys.stdin.readline

a, b = map(int, input().split())

num = 1
cnt = 0

arr = []

while cnt <= b:
    arr.append(num)
    cnt += 1
    if cnt == num:
        num += 1
        cnt = 0

print(sum(arr[a - 1 : b]))