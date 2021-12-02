from sys import *

horizontal_pos = 0
vertical_pos = 0
horizontal_pos2= 0
vertical_pos2= 0
aim = 0

with open("advent-of-code-2021/day 2/data.txt", "r") as file:
    for line in file:
        value = int(line[-2])
        #print(line)
        if line[0] == 'f':
            horizontal_pos += value
            horizontal_pos2 += value
            vertical_pos2 += aim * value
        elif line[0] == 'u':
            vertical_pos-= value
            vertical_pos2-= value
            aim -= value
        elif line[0] == 'd':
            vertical_pos+= value
            vertical_pos2+= value
            aim += value

print("multiplied values (depth and horizontal)",horizontal_pos * vertical_pos)
print(horizontal_pos2 * vertical_pos2)