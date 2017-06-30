#include<stdlib.h>

int main(){

	int intSize = sizeof(int);
	int shortSize = sizeof(short);
	int charSize = sizeof(char);
	int longSize = sizeof(long);

	printf("Size of short: %d\n", shortSize);
	printf("Size of int: %d\n", intSize);
	printf("Size of char: %d\n", charSize);
	printf("Size of long: %d\n", longSize);

	return 0;
}
