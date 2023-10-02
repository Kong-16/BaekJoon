import sys

input = sys.stdin.readline

t = int(input().rstrip())

for test_case in range(t):
    y = 0
    k = 0
    for _ in range(9):
        y_plus, k_plus = map(int, input().split())
        y += y_plus
        k += k_plus
    if y < k:
        print("Korea")
    elif k < y:
        print("Yonsei")
    else:
        print("Draw")