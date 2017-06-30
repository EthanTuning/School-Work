#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>


char alphabets[]= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

int countString(const char *fileName, char *str);
int countEmptyLines(const char* fileName);

int main(int argc, char *argv[]){

   	if(argc != 3){
       		printf("Incorrect Parameters.\n");
       		exit(0);
   	}

   	int word_count = countString(argv[1], argv[2]);
   	int empty_line = countEmptyLines(argv[0]);

   	printf("The string \"%s\" occurs %d times in File \"%s\".\n", argv[2],  word_count, argv[1]);
   	printf("File \"%s\" has %d empty lines.\n", argv[1], empty_line);

   	return 0;

}

int countString(const char* fileName, char *str){
    	FILE *f1;
    	int word_count = 0;

    	f1 = fopen(fileName, "r");

    	if (f1 == NULL){
        	perror("Cannot open files .....");
        	exit(EXIT_FAILURE);
    	}

	char buff[512];

	while(fgets(buff, 512, f1) != NULL){
		if((strstr(buff, str)) != NULL){
			word_count++;
		}
	}

    	fclose(f1);
	return word_count;
}



int countEmptyLines(const char *fileName){

    	int emptyLine = 0;
	char line[300];

    	FILE *fp = fopen("poem.txt", "r");
    	if (fp == NULL) {
        	printf("Error: Could not open specified file!\n");
        	return -1;
    	}

	else{
		while(fgets(line, 300, fp)){
			int i = 0;
			int len = strlen(line);
			emptyLine++;

			for(i = 0; i < len; i++){
				if(line[i] != '\n' && line[i] != '\t' && line[i] != ' '){
					emptyLine--;
					break;
				}
			}
		}
		return emptyLine;
	}
}


