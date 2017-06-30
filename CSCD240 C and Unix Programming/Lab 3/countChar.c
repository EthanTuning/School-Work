#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 100

int main(){
	char c;
	int i;
	char sentence[MAXSIZE];
	int alphabetsCount = 0;

	printf("Type a sentece: \n");
	scanf(" %s", &sentence);
	printf("Type a character that you'd like to find the number of occurences in a sentence: \n");
	scanf(" %c", &c);

	for(i = 0; i < strlen(sentence); i++){
		if(sentence[i] == c){
			alphabetsCount++;
		}
	}

	printf("Alphabet %c has a frequency %d\n", c, alphabetsCount);
	return 0;
}
