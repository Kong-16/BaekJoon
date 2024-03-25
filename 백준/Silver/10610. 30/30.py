import sys

input = sys.stdin.readline

n = input().rstrip()

zero = False
three = False
sum = 0
ans = -1

for i in range(len(n)):
    if n[i] == "0":
        zero = True
    sum += int(n[i])

if sum % 3 == 0 and zero:
    print("".join(sorted(n, reverse=True)))
else:
    print(-1)