import sys
from math import gcd

input = sys.stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n, *arr = map(int, input().split())
    s = 0
    for i in range(n):
        for j in range(i + 1, n):
            s += gcd(arr[i], arr[j])
    print(s)