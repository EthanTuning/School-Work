#include <stdio.h>
#include <ctype.h>

#define MAXROWS 100
#define NUM_ALPHABETS 26

int main(){

	int count, i, j, k;

	char sentence[MAXROWS];
	char alphabets[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	int frequency[NUM_ALPHABETS];

	for (i = 0; i < NUM_ALPHABETS; i++){
		frequency[i] = 0;
	}

	// step 1: count the number of characters in the sentence read from user input

	printf("Please enter a sentence: ");
	fgets(sentence, sizeof(sentence), stdin);
	count = strlen(sentence);
	// step 2:Find out the frequency of the alphabets

	int m;

	for(m = 0; m < count; m++){
		if(sentence[m] >= 'a' && sentence[m] <= 'z'){
			frequency[sentence[m] - 97]++;
		}
		else if(sentence[m] >= 'A' && sentence[m] <= 'Z'){
			frequency[sentence[m] - 65]++;
		}
	}
	// step 3: Display the histogram

	printf("%s%12s%15s\n\n", "Alphabets", "Frequency", "Histogram");

	for (j = 0; j < 26; j++){

		printf("%8c %10d            ", alphabets[j], frequency[j]);

		for (k = 0; k < frequency[j]; k++)

			printf("*");
		printf("\n");
	}

	return 0;
}
