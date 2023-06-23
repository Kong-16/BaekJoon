import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    a, b = input().split()
    if sorted(a) == sorted(b):
        print("{} & {} are anagrams.".format(a, b))
    else:
        print("{} & {} are NOT anagrams.".format(a, b))