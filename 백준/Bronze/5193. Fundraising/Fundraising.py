import sys

input = sys.stdin.readline

tc = int(input().rstrip())

for test_case in range(1, tc + 1):
    c, d, t = map(int, input().split())
    candiates = [0 for _ in range(c + 1)]
    donators = [[0 for _ in range(c + 1)] for _ in range(d + 1)]
    # donators = [0 for _ in range(d + 1)]
    # candidates = [[0 for _ in range(d + 1)] for _ in range(c + 1)]
    violators = []
    for _ in range(t):
        di, ci, mi = map(int, input().split())
        donators[di][ci] += mi
    for i in range(1, d + 1):
        if 40000 < sum(donators[i]) or list(filter(lambda x: 2100 < x, donators[i])):
            violators.append(i)
    print("Data Set {}:".format(test_case))
    if violators:
        print("Violators:")
        for v in violators:
            print(v)
    else:
        print("No violations")