#Ethan Tuning 2/22/2015

def main():
    print("Welcome to My Numbers Maintenance Program!")
    num = 99
    menu()
    the_choice(num)

def menu():
    print("1.) Add Value to List")
    print("2.) Delete Value from List (by value)")
    print("3.) Delete Value form List (by location in list")
    print("4.) Display List (with location)")
    print('5.) Read Values from File: "numbers1.txt"')
    print('6.) Write Values to File: "numbers1.txt"')
    print("0.) Exit")

def user_input():
    num = int(input("What would you like to do?:"))
    return num

def the_choice(num):
    l = []
    while num != 0:
        num = user_input()
        if num == 1:
            add_value(l)
        elif num == 2:
            delete_value(l)
        elif num == 3:
            delete_by_location(l)
        elif num == 4:
            display(l)
        elif num == 5:
            read(l)
        elif num == 6:
            write(l)
    if num == 0:
        exit()
        print("Bye!!!")

def add_value(l):
    num = int(input("Enter a number:"))
    l.append(num)
    l.sort
    print("Done.")
    return l

def delete_value(l):
    num = int(input("Enter number to remove:"))
    l.remove(num)
    print("Done.")
    return l

def delete_by_location(l):
    l.sort
    num = int(input("Enter location of number:"))
    l.pop(num)
    print("Done.")
    return l

def display(l):
    l.sort()
    for i in l:
        a = l.index(i)
        print(i, a)


def read(l):
    fh = open("numbers1.txt", "r")
    num = fh.readlines()
    for i in l:
        l.append(i)
    fh.close
    return l

def write(l):
    fh2 = open("numbers1.txt", "w")
    for num in l:
        et = str(l.remove(num))
        fh2.write(et + "\n")
    print("Done.")
    fh2.close


main()


