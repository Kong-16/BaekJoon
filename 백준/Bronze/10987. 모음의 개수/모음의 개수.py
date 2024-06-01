import sys

input = sys.stdin.readline

vowels = "aeiou"

inp_str = input().rstrip()

cnt = 0
for c in inp_str:
    if c in vowels:
        cnt += 1
print(cnt)