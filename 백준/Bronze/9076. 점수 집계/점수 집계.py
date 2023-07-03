import sys

input = sys.stdin.readline

t = int(input().strip())

for _ in range(t):
    scores = list(map(int, input().split()))
    scores.sort()
    if 4 <= scores[3] - scores[1]:
        print("KIN")
    else:
        print(scores[1] + scores[2] + scores[3])