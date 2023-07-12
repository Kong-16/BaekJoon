import sys

input = sys.stdin.readline

n, k = map(int, input().split())

sequence = list(map(int, input().split()))
sequence.insert(0, 0)
prefix = [0]

for i in range(1, n + 1):
    prefix.append(sequence[i] + prefix[i - 1])

idx = 0
max_num = -300
for i in range(n + 1 - k):
    max_num = max(max_num, prefix[i + k] - prefix[i])

print(max_num)
