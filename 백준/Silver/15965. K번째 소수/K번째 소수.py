import sys

input = sys.stdin.readline

max_prime = 7368787
eratosthenes = [True for _ in range(max_prime + 10)]

eratosthenes[1] = False
for i in range(2, max_prime + 10):
    if eratosthenes[i]:
        mul = 2
        while i * mul < max_prime + 10:
            eratosthenes[i * mul] = False
            mul += 1

k = int(input().rstrip())

cnt = 0
i = 1
while cnt < k:
    i += 1
    if eratosthenes[i]:
        cnt += 1

print(i)