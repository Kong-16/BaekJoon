import sys
import collections

input = sys.stdin.readline

n = int(input().rstrip())

deck = collections.deque()
for i in range(n):
    deck.append(i + 1)

while deck:
    print(deck.popleft(), end=" ")
    if deck:
        deck.append(deck.popleft())