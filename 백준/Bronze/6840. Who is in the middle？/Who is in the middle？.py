import sys

input = sys.stdin.readline

my_list = [int(input().strip()) for _ in range(3)]

print(sorted(my_list)[1])