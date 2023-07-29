import sys

input = sys.stdin.readline

n = int(input().strip())

my_list = list(map(int, input().split()))
print(max(my_list) * min(my_list))