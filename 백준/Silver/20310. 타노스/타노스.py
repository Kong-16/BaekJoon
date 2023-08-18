import sys

input = sys.stdin.readline

nums = [0, 0]

inp_str = input().strip()

for c in inp_str:
    nums[int(c)] += 1

nums[0] //= 2
nums[1] //= 2

for i in range(len(nums)):
    for _ in range(nums[i]):
        print(i, end="")