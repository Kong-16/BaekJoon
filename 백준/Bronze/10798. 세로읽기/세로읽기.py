import sys

input = sys.stdin.readline


arr = []
for _ in range(5):
    arr.append(input().rstrip())

for i in range(15):
    for j in range(5):
        if len(arr[j]) > i:
            print(arr[j][i], end="")
print()