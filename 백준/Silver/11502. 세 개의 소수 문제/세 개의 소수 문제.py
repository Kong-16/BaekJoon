import sys

input = sys.stdin.readline

MAX_NUM = 1001
era = [True for _ in range(MAX_NUM)]
era[1] = False
prime = []
for i in range(2, MAX_NUM):
    if era[i]:
        prime.append(i)
        mul = 2
        while mul * i < MAX_NUM:
            era[mul * i] = False
            mul += 1

t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    possible = False
    for i in prime:
        if n < i:
            continue
        for j in prime:
            if n < i + j:
                break
            for k in prime:
                if n < i + j + k:
                    break
                if i + j + k == n and not possible:
                    possible = True
                    print("{} {} {}".format(i, j, k))
    if not possible:
        print("0")