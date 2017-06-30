#include<stdio.h>

int main(){
	int c;
	char dummy[10];

	while(c != 'q' && c != 'Q'){
		printf("Enter a value : ");
		scanf(" %d", &c);
		printf(" \n");
		printf("You entered : %d\n", c);
	}
	return 0;
}
