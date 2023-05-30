import sys

input = sys.stdin.readline

fibbo = []

fibbo.append([1, 0])
fibbo.append([0, 1])
for i in range(2, 41):
    zero = fibbo[i - 2][0] + fibbo[i - 1][0]
    one = fibbo[i - 2][1] + fibbo[i - 1][1]
    fibbo.append([zero, one])

test_case = int(input())

for _ in range(test_case):
    n = int(input())
    print(*fibbo[n])