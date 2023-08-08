import sys

input = sys.stdin.readline

number = [False for _ in range(10)]

for _ in range(5):
    inp = int(input().strip())
    number[inp] = not number[inp]

for i in range(10):
    if number[i]:
        print(i)