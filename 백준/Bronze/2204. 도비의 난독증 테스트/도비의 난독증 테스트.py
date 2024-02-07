import sys

input = sys.stdin.readline

while True:
    n = int(input().rstrip())
    if not n:
        break
    arr = []
    for i in range(n):
        inp = input().rstrip()
        arr.append([inp, inp.upper()])
    arr.sort(key=lambda x: x[1])
    print(arr[0][0])