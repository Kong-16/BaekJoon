import sys

input = sys.stdin.readline

n = int(input().rstrip())

if n % 2:
    print("SK")
else:
    print("CY")