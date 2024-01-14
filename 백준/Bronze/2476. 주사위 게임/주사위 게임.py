import sys

input = sys.stdin.readline

n = int(input().rstrip())

person = [0 for _ in range(n)]
for i in range(n):
    arr = list(map(int, input().split()))
    arr.sort()
    if arr[0] == arr[2]:
        person[i] = 10000 + arr[0] * 1000
    elif arr[0] == arr[1]:
        person[i] = 1000 + arr[0] * 100
    elif arr[1] == arr[2]:
        person[i] = 1000 + arr[1] * 100
    else:
        person[i] = arr[2] * 100
print(max(person))