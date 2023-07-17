import sys

input = sys.stdin.readline

alphabets = [0 for _ in range(27)]
TO_INT = 65
inpStr = input().strip()

for a in inpStr:
    alphabets[ord(a) - TO_INT] += 1

valid = 0
left = ""
center = ""
right = ""
for i in range(len(alphabets)):
    a = chr(i + TO_INT)
    if alphabets[i] % 2 == 1:
        center = center + a
        valid += 1
    for _ in range(alphabets[i] // 2):
        left = left + a
        right = a + right

msg = left + center + right if valid < 2 else "I'm Sorry Hansoo"
print(msg)