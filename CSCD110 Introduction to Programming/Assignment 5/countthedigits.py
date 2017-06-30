#Ethan Tuning 1/28/15
num1 = int(input("Enter an integer:"))
num2 = int(input("Enter another integer:"))
answer = 0
for num in range(num1, num2+1):
    while num >= 1:
        eth = (num % 10)
        num = (int(num / 10))
        answer += eth
print(answer)
