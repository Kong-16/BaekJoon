input()
h = [*map(int, input().split())]
h = [h[i] - h[i - 1] for i in range(1, len(h))]
h.append(0)

max_v = 0
i, v = 0, 0
while i < len(h):
    if h[i] <= 0:
        max_v = max(max_v, v)
        v = 0
    else:
        v += h[i]
    i += 1
print(max_v)