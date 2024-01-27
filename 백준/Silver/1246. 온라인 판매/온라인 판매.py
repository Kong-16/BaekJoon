import sys

input = sys.stdin.readline

n, m = map(int,input().split())
arr = [0 for _ in range(m)]

max_num = 0
max_cost = -1

for i in range(m):
    arr[i] = int(input().rstrip())
    
arr.sort()

for i in range(m):
    if max_num < arr[i] * min(n,m-i):
        max_num = arr[i] * min(n,m-i)
        max_cost = arr[i]
print("{} {}".format(max_cost,max_num))