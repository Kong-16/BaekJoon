import sys

input = sys.stdin.readline

str = input().split()[0]
mobis = {'M', 'O', 'B', 'I', 'S'}

if mobis.issubset(set(str)):
    print("YES")
else:
    print("NO")