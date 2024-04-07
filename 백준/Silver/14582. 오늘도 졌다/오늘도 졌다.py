import sys

input = sys.stdin.readline

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a_score = 0
b_score = 0

flag = True

for i in range(9):
    a_score += a[i]
    if b_score < a_score:
        flag = False
        break
    b_score += b[i]

print("No" if flag else "Yes")