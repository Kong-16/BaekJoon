import sys

input = sys.stdin.readline

a, b = map(int, input().split())

arr = []

length = 0
num = 1

while length < b:
    num_cnt = 0
    while num_cnt < num:
        arr.append(num)
        num_cnt += 1
        length += 1
    num += 1

print(sum(arr[a - 1 : b]))