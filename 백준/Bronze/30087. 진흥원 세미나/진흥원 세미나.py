import sys

input = sys.stdin.readline

d = {}
d["Algorithm"] = 204
d["DataAnalysis"] = 207
d["ArtificialIntelligence"] = 302
d["CyberSecurity"] = "B101"
d["Network"] = 303
d["Startup"] = 501
d["TestStrategy"] = 105

n = int(input().rstrip())

for _ in range(n):
    inp = input().rstrip()
    print(d[inp])