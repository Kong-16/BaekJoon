import sys

input = sys.stdin.readline

arr = sorted(list(map(int, input().split())))
dic = {"A": arr[0], "B": arr[1], "C": arr[2]}

seq = input().rstrip()

for i in seq:
    print(dic[i], end=" ")