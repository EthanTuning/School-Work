# Ethan Tuning 2/6/2015

def sphereSurfaceArea(rad):
    pi = 3.14159
    surfaceArea = 4 * pi * rad ** 2
    return surfaceArea

def sphereVolume(rad2):
    pi = 3.14159
    volume = (4/3) * pi * rad2 ** 3
    return volume

def circleCircumference(rad3):
    pi = 3.14159
    circumference = 2 * pi * rad3
    return circumference

def circleArea(rad4):
    pi = 3.14159
    area = pi * rad4 ** 2
    return area

def radiusInfo(rad5):
    print("Surface Area of Sphere of Radius" ,rad5, "is:" ,sphereSurfaceArea(rad5))
    print("Volume of Sphere of radius" ,rad5, "is:" ,sphereVolume(rad5)) 
    print("Circumference of circle of radius" ,rad5, "is:" ,circleCircumference(rad5)) 
    print("Area of circle of radius" ,rad5, "is:" ,circleArea(rad5))
    return

def radiusInfoUserInput():
    rad6 = float(input("Enter a radius:"))
    radiusInfo(rad6)
    return

def main():
    radiusInfo(6.1)
    print()
    radiusInfo(7.5)
    print()
    radiusInfo(8)
    print()
    radiusInfo(11.25)
    print()
    radiusInfoUserInput()
    return

main()
