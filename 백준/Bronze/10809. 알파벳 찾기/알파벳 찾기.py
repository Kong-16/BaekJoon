import sys

input = sys.stdin.readline

inp = input()

for i in range(ord('a'), ord('z') + 1):
    alphabet = chr(i)
    print(inp.find(alphabet), end=" ")