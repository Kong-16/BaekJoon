import sys

input = sys.stdin.readline

n, l = map(int, input().split())

num = [i + 1 for i in range(n)]
if l == 1:
    arr = [int(input().rstrip())]
else:
    arr = list(map(int, input().split()))

num_it = -1
arr_it = 0
cnt = 0

while 1 < len(num):
    cnt += 1
    num_it += 1
    if len(num) == num_it:
        num_it = 0
    if cnt == arr[arr_it]:
        num.pop(num_it)
        cnt = 0
        num_it -= 1
        arr_it += 1
        if arr_it == len(arr):
            arr_it = 0

print(*num)