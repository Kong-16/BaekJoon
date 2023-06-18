import sys
import math

input = sys.stdin.readline

n = int(input())

house = sorted(list(map(int, input().split())))

print(house[(len(house) - 1) // 2])