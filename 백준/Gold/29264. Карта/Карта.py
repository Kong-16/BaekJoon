import sys

input = sys.stdin.readline

inp = input().rstrip().replace(" ", "")

l = len(inp)

alp = {}

for i in range(l):
    if alp.get(inp[i]):
        alp[inp[i]].append(i)
    else:
        alp[inp[i]] = [i]

cnt = 0

for arr in alp.values():
    if 1 < len(arr):
        tot = 0
        for i in range(1, len(arr)):
            tot += arr[i - 1] + 1
            cnt += arr[i] * i - tot
print(cnt)
