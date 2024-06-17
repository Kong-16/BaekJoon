import sys
import collections

input = sys.stdin.readline
n, m = map(int, input().split())

order = list(map(int, input().split()))
arr = [i for i in range(1, n + 1)]

it = 0
cnt = 0

for i in order:
    s = it % n
    e = it % n
    while arr[s] != i and arr[e] != i:
        s = (s - 1 + n) % n
        e = (e + 1) % n
        cnt += 1
    if arr[s] == i:
        it = s
        arr.pop(s)
    else:
        it = e
        arr.pop(e)
    n -= 1

print(cnt)