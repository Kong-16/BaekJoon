import sys

input = sys.stdin.readline

inp_str = input().rstrip()

arr = []

for i in range(len(inp_str)):
    arr.append(inp_str[i:])

arr.sort()

for i in arr:
    print(i)