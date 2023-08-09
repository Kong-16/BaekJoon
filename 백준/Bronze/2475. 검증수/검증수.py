import sys

input = sys.stdin.readline

nums = list(map(int, input().split()))

total = 0
for i in nums:
    total += i ** 2

print(total % 10)