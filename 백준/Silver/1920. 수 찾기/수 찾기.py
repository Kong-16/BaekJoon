import sys

input = sys.stdin.readline

n = int(input())

inp = set(map(int, input().split()))

m = int(input())

tmp = list(map(int, input().split()))

for i in tmp:
    if i in inp:
        print(1)
    else:
        print(0)