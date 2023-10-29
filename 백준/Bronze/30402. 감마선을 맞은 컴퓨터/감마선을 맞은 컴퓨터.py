import sys

input = sys.stdin.readline

n = 15
arr = [[] for _ in range(15)]

ans = ""
cats = {'w': 'chunbae', 'b': 'nabi', 'g': 'yeongcheol'}
for i in range(n):
    arr[i] = input().split()

for i in range(n):
    for j in range(n):
        if (arr[i][j] in ['w', 'b', 'g']):
            ans = arr[i][j]
            break

print(cats[ans])