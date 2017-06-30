#Ethan Tuning 1/16/15

your_score = int(input('Enter your score:'))
opponents_score = int(input('Enter opponents score'))
print()
print('You have scored',your_score,'points')
print('Your opponent has scored',opponents_score,'points')
print()
if your_score >= 4 and your_score - opponents_score >= 2:
    print('You win!! :)')
if opponents_score >= 4 and opponents_score - your_score >= 2:
    print('You Lost!! :(')
if your_score == 0 and opponents_score == 0:
    print('Love-Love')
if your_score == 1 and opponents_score == 1:
    print('Fifteen-Fifteen')
if your_score == 2 and opponents_score == 2:
    print('Thirty-Thirty')
if your_score == opponents_score and your_score >= 3:
    print('Deuce')
if your_score == 0 and opponents_score == 1:
    print('Love-Fifteen')
if your_score == 0 and opponents_score == 2:
    print('Love-Thirty')
if your_score == 0 and opponents_score == 3:
    print('Love-Forty')
if opponents_score == 0 and your_score == 1:
    print('Fifteen-Love')
if opponents_score == 0 and your_score == 2:
    print('Thirty-Love')
if opponents_score == 0 and your_score == 3:
    print('Forty-Love')
if your_score == 1 and opponents_score == 2:
    print('Fifteen-Thirty')
if your_score == 1 and opponents_score == 3:
    print('Fifteen-Forty')
if your_score == 2 and opponents_score == 1:
    print('Thirty-Fifteen')
if your_score == 2 and opponents_score == 3:
    print('Thirty-Forty')
if your_score == 3 and opponents_score == 2:
    print('Forty-Thirty')
if your_score == 3 and opponents_score == 1:
    print('Forty-Fifteen')
if your_score >= 3 and opponents_score - your_score == 1:
    print('Advantage Out')
if opponents_score >= 3 and your_score - opponents_score == 1:
    print('Advantage In')
