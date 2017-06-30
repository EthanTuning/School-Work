#include<stdio.h>

int main(){
	int i = 0;
	int grade, sum = 0;
	printf("Please input 10 grades, separated by a semi-colon:");
	while(i<10){
		scanf("%d;",&grade);
		sum += grade;
		i++;
	}
	printf("Average grade for 10 students is %d\n", sum/10");
	return 0;
}
