import sys

input = sys.stdin.readline

i = 2
max_num = 302
arr = [1 for _ in range(max_num)]
w = [0 for _ in range(max_num)]
while i < max_num:
    arr[i] = arr[i - 1] + i
    w[i - 1] = w[i - 2] + (i - 1) * arr[i]
    i += 1
t = int(input().rstrip())
for _ in range(t):
    n = int(input().rstrip())
    print(w[n])