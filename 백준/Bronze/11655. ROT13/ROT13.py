import sys

input = sys.stdin.readline

a = ord("a")
z = ord("z")
A = ord("A")
Z = ord("Z")

inp_str = input().rstrip()

encoded = ""

for c in inp_str:
    i = ord(c)
    isAlp = False
    if a <= i and i <= z:
        isAlp = True
        num = a
    elif A <= i and i <= Z:
        isAlp = True
        num = A
    if isAlp:
        encoded += chr((i - num + 13) % 26 + num)
    else:
        encoded += c

print(encoded)