import sys

input = sys.stdin.readline

MAX = 10000
isPrime = [True for _ in range(MAX + 1)]

isPrime[1] = False
i = 2
while i <= MAX:
    if (isPrime[i] == True):
        mul = 2
        while i * mul <= MAX:
            isPrime[i * mul] = False
            mul += 1
    i += 1
m = int(input())
n = int(input())

sum = 0
min = MAX
for i in range(m, n + 1):
    if isPrime[i]:
        if i < min:
            min = i
        sum += i
if sum == 0:
    print(-1)
else:
    print(sum)
    print(min)