import sys

input = sys.stdin.readline

arr = sorted(list(map(int, input().split())))

print(abs((arr[0] + arr[3]) - (arr[1] + arr[2])))