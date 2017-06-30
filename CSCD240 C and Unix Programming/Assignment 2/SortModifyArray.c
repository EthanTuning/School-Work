#include <stdio.h>
#include <stdlib.h>

void swapElements(int *a, int *b);
void sortArray(int *array, const int size);
void changeElements(int *val);

int main(){

	int i, n, *x, val = 0;

	printf("How many numbers need to be sorted? ");
	scanf("%d", &n);

	printf("\n");

	x = (int *)malloc(n*sizeof(int));

        printf("Here is the list of numbers read: \n");

	for (i = 0; i < n; i++){
		printf("i = %d x = ", i);
		scanf(" %d", &x[i]);

	}

	sortArray(x, n);
	printf("Here is the sorted array: \n");

	for(i = 0; i < n; i++){
		printf("i = %d x = %d\n", i, x[i]);
	}

	printf("\n");

	printf("Which index element you want to modify? ");
	scanf("%d", &val);
	changeElements(&x[val]);

	printf("Here is the array with a particular array element changed: \n");

        for(i = 0; i < n; i++){
		printf("i = %d x = %d\n", i, x[i]);
	}

	printf("\n");

	sortArray(x, n);
	printf("Here is the sorted array after a particular array element changed:  \n");

	for(i = 0; i < n; i++){
		printf("i = %d x = %d\n", i, x[i]);
	}

	free(x);
        return 0;
}

void sortArray(int *array, const int size){

	int i, j;
	for(i = 0; i < size-1; i++){
		for(j = 0; j < size-1; j++){
			if(array[j] > array[j+1]){
				swapElements(&array[j],&array[j+1]);
			}
		}
	}
	return;
}

void swapElements(int *i, int *j){

	int temp;
	temp = *j;
	*j = *i;
	*i = temp;

	return;
}

void changeElements(int *val){
	*val *= 2;

	return;
}
