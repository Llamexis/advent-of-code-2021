from sys import *

horizontal_pos = 0
vertical_pos = 0

with open("advent-of-code-2021/day 2/data.txt", "r") as file:
    for line in file:
        #print(line)
        if line[0] == 'f':
            horizontal_pos += int(line[-2])
        elif line[0] == 'u':
            vertical_pos-= int(line[-2])
        elif line[0] == 'd':
            vertical_pos+= int(line[-2])

print("multiplied values (depth and horizontal)",horizontal_pos * vertical_pos)