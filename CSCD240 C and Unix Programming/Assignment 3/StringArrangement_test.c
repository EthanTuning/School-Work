#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void sortString(char *s[], int count);

int main(){

        int i;
        char buff[BUFSIZ];

        int count;
       	// 's' is a pointer to a char pointer, initially 's' is allocated storage for one char pointer
        char** s= (char**)malloc(sizeof(char*));

        printf("Here is the list of unsorted names: \n\n");

        // Keep of reading unlimited number of names until EOF (Ctrl + D) is reached
        for(count = 0; fgets(buff, sizeof(buff), stdin); count++){

           	//Step 1: allocate sufficient storage for s[count] to store the content in buff plus one byte for '\0'; use malloc function
		s[count] = malloc(sizeof(s[count]+1));
           	//Step 2: copy the contents of 'buf' to 's[count]', use strcpy
		strcpy(s[count], buff);
           	//Step 3: resize the array of pointers pointed to by 's' to increase its size for next pointers, use realloc function
		s = (char**)realloc(s,(count+1)*sizeof(s)+1);
        }

       	// EOF reached. Now count the number of strings read

        printf("\nCount is %d\n\n", count);

       	// Now sort string using sortString function

       	//Step 4: implement sortString function for the above-mentioned function declaration
	sortString(s, count);

	printf("Here is the list of sorted names: \n\n");

      	for(i = 0; i < count; i++){
      		printf("%s",s[i]);
        }

	//step 5:
	for(i = 0; i  < count; i++){
		free(s[i]);
	}
	free(s);
     	// free the allocated memory;
     	return 0;
}

void sortString(char *s[], int count){
	char * temp;
	int i, item;

	for(item = 0; item < count-1; item++){
		for(i = item + 1; i < count; i++){
			if(strcmp(s[item], s[i]) > 0){
				temp = s[item];
				s[item] = s[i];
				s[i] = temp;
			}
		}
	}
}
