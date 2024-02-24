import sys

input = sys.stdin.readline

while True:
    num = input().rstrip()
    if num == "0":
        break
    half = len(num) // 2
    flag = True
    for i in range(half):
        if num[i] != num[-(i + 1)]:
            flag = False
            break
    print("yes" if flag else "no")