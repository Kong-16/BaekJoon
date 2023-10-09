import sys

input = sys.stdin.readline

w, h = map(int, input().split())

print("{:.1f}".format(w * h / 2))