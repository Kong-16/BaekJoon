import sys

input = sys.stdin.readline

t = int(input())

for test_case in range(1, t + 1):
    a, b = list(map(int, input().split()))
    print("Case #{}: {}".format(test_case, a + b))