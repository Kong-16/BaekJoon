import sys

input = sys.stdin.readline

loop = [[]]

for num in range(1, 101):
    fDigit = ((num - 1) % 10) + 1
    sub_loop = [fDigit]
    while True:
        fDigit = (((fDigit * num) - 1) % 10) + 1
        if fDigit in sub_loop:
            break
        sub_loop.append(fDigit)
    loop.append(sub_loop)

t = int(input())
for _ in range(t):
    a, b = map(int, input().split())
    sub_loop = loop[a]
    idx = b % len(sub_loop)
    print(sub_loop[idx - 1])