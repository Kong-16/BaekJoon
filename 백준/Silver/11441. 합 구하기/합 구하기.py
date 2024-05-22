import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = list(map(int, input().split()))
arr.insert(0, 0)
prefix = [0]
for i in range(1, n + 1):
    prefix.append(prefix[i - 1] + arr[i])

m = int(input().rstrip())

for _ in range(m):
    a, b = map(int, input().split())
    print(prefix[b] - prefix[a - 1])