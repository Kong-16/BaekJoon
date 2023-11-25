import math
import sys

input = sys.stdin.readline

numbers = [0 for _ in range(11)]
inp_str = input().rstrip()

for c in inp_str:
    numbers[int(c)] += 1

numbers[6] = numbers[9] = math.ceil((numbers[6] + numbers[9]) / 2)

print(max(numbers))