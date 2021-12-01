from sys import *

dane = []
sums =[]
increased = 0

with open("day 1/dane.txt", "r") as file:
    for line in file:
        dane.append(int(line))

for iter in range(0, len(dane) - 2):
    sums.append(dane[iter + 0] + dane[iter + 1] + dane[iter + 2])

print()
for value in range(len(sums)-1):
    if sums[value] < sums[value + 1]:
        increased+= 1
print(increased)