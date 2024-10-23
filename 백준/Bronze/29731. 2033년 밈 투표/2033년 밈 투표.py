import sys

input = sys.stdin.readline

arr = [
    "Never gonna give you up",
    "Never gonna let you down",
    "Never gonna run around and desert you",
    "Never gonna make you cry",
    "Never gonna say goodbye",
    "Never gonna tell a lie and hurt you",
    "Never gonna stop",
]

n = int(input().rstrip())

flag = True
for _ in range(n):
    if input().rstrip() not in arr:
        flag = False

print("No" if flag else "Yes")