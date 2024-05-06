import sys

input = sys.stdin.readline

n = int(input().rstrip())

five = n // 5
two = 0

while 0 <= five:
    left = n - five * 5
    if left % 2:
        left += 5
        five -= 1
    else:
        two = left // 2
        break

print(five + two)