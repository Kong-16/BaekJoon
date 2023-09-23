import sys

input = sys.stdin.readline

n = int(input().rstrip()) - 1

str_inp = "WelcomeToSMUPC"

print(str_inp[n % 14])