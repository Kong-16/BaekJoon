import sys

input = sys.stdin.readline

n = int(input().rstrip())

print("{} {}".format(int(n * 0.78), int(n * 0.8 + n * 0.2 * 0.78)))