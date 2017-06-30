#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct person readData();
void printData(struct person temp);

struct person{
	char name[BUFSIZ];
	char ssn[BUFSIZ];
	int age;
	float height;
	float weight;
};

struct person readData(){

	struct person temp;
	char buff[BUFSIZ];

	gets(temp.name);
        gets(temp.ssn);
	temp.age = atoi(gets(buff));

	temp.height = atof(gets(buff));
        temp.weight = atof(gets(buff));

	return temp;
}

void printData(struct person temp){

	printf("%s\n%s\nAge = %d\nHeight(cm) = %g\nWeight(kg) = %g\n", temp.name, temp.ssn, temp.age, temp.height, temp.weight);

}

int main(){

	struct person p1;

        printf("Reading data ......\n");
	p1 = readData();
        printf("\n");
        printf("Printing data ....\n");
	printData(p1);

	return 0;
}
