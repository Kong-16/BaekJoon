import sys

input = sys.stdin.readline

num = 97
alp = ord("z") - ord("a") + 1

arr = [[0 for _ in range(alp)] for _ in range(2)]

for i in range(2):
    inp = input().rstrip()
    for c in inp:
        arr[i][ord(c) - num] += 1

cnt = 0
for i in range(alp):
    cnt += abs(arr[0][i] - arr[1][i])

print(cnt)