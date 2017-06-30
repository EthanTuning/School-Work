#Ethan Tuning 2/10/2015

import random

def intro():
    print("This is a Dice Simulation!")
    
def percentages(total,rolls):
    return(format((total/rolls),'.2%'))

def stats():
    rolls = int(input("Enter Number of Rolls:"))
    total1 = 0
    total2 = 0
    total3 = 0
    total4 = 0
    total5 = 0
    total6 = 0
    total7 = 0
    total8 = 0
    total9 = 0
    total10 = 0
    total11 = 0
    doubles = 0
    for num in range(rolls):
        num1 = (random.randint(1, 6))
        num2 = (random.randint(1, 6))
        total = num1 + num2
        if total == 2:
            total1 += 1
        elif total == 3:
            total2 += 1
        elif total == 4:
            total3 += 1
        elif total == 5:
            total4 += 1
        elif total == 6:
            total5 += 1
        elif total == 7:
            total6 += 1
        elif total == 8:
            total7 += 1
        elif total == 9:
            total8 += 1
        elif total == 10:
            total9 += 1
        elif total == 11:
            total10 += 1
        elif total == 12:
            total11 += 1
        if num1 == num2:
            doubles += 1
    print("2-" ,total1, "-" ,percentages(total1,rolls))
    print("3-" ,total2, "-" ,percentages(total2,rolls))
    print("4-" ,total3, "-" ,percentages(total3,rolls))
    print("5-" ,total4, "-" ,percentages(total4,rolls))
    print("6-" ,total5, "-" ,percentages(total5,rolls))
    print("7-" ,total6, "-" ,percentages(total6,rolls))
    print("8-" ,total7, "-" ,percentages(total7,rolls))
    print("9-" ,total8, "-" ,percentages(total8,rolls))
    print("10-" ,total9, "-" ,percentages(total9,rolls))
    print("11-" ,total10, "-" ,percentages(total10,rolls))
    print("12-" ,total11, "-" ,percentages(total11,rolls))
    print("Doubles-" ,doubles, "-" ,percentages(doubles,rolls))
    return 
        
def main():
    intro()
    stats()
    return

main()
