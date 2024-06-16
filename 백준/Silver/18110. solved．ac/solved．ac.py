import sys

input = sys.stdin.readline

n = int(input().rstrip())

exc = (n * 15 + 100 // 2) // 100
arr = []
for _ in range(n):
    arr.append(int(input().rstrip()))

arr.sort()

print(
    round((sum(arr[exc : n - exc]) + (n - (2 * exc)) // 2) // (n - (2 * exc)))
    if 0 < n
    else 0
)