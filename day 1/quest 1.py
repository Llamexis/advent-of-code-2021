from sys import *
previous_value = 0
dane = []
increased = 0
with open("day 1\dane.txt", "r") as file:
    for line in file:
        dane.append(int(line))
for value in range(len(dane)-1):
    if dane[value] < dane[value + 1]:
        increased+= 1
print(increased)