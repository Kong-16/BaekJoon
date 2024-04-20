import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = list(map(int, input().split()))

arr_sum = sum(arr)
ans = 0
for i in arr:
    ans += (arr_sum - i) * i

print(ans // 2)