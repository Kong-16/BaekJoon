import sys

input = sys.stdin.readline

k = int(input().rstrip())

for test_case in range(1, k + 1):
    weight = []
    fish = []
    n, m = map(int, input().split())
    if m == 1:
        weight.append(int(input().rstrip()))
    else:
        weight = list(map(int, input().split()))
    for _ in range(n):
        value = list(map(int, input().split()))
        result = sum(map(lambda x, y: x * y, weight, value))
        fish.append(result)
    max_num = max(fish)
    print("Data Set {}:".format(test_case))
    for i in range(n):
        if fish[i] == max_num:
            print(i + 1)
    print()