import sys

input = sys.stdin.readline
n = 10001
numbers = [True for _ in range(n)]
for i in range(n):
    tmp = i
    while i:
        tmp += i % 10
        i //= 10
    if tmp < n:
        numbers[tmp] = False

for i in range(1, n):
    if numbers[i]:
        print(i)