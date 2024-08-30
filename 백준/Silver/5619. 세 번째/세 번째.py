import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = []
comb = []
for _ in range(n):
    arr.append(int(input().rstrip()))

arr.sort()


cnt = 0
for i in arr[:4]:
    for j in arr[:4]:
        if i == j:
            continue
        num = str(i) + str(j)
        comb.append(int(num))
comb.sort()
print(comb[2])