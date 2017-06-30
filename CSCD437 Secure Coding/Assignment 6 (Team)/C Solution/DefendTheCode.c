/*
 * Ethan Tuning, Gavin Rouse, Collin Nolen
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <regex.h>
#include <unistd.h>
#include <time.h>
#include "md5.h"

#define MAX_STRING 50
#define MAX_CHAR 255

void getPassword(char* enterOrRenter, char* thePassword);
void getHashedPassword();
void getName(char* firstOrLast, char* name);
void getFilename(char* inOrOut, char* name);
void strip(char* array);
char * current_directory();
void combiner(char *firstName, char *lastName,char *inputFile, char *outputFile,  long* intOne, long* intTwo);
FILE *  findFile(char*, int);
void getInt(long * theInt);
void discardExtraSTDIN();
long addInts(long intOne, long intTwo);
long multInts(long intOne, long intTwo);

int main(){
    char firstName[MAX_STRING], lastName[MAX_STRING], inputFile[MAX_STRING], outputFile[MAX_STRING];
    long intOne=0, intTwo=0;
	
    getName("first", firstName);
    getName("last", lastName);
	getHashedPassword();
    getInt(&intOne);
    getInt(&intTwo);
    getFilename("in", inputFile);
    getFilename("out", outputFile);

    combiner(firstName, lastName, inputFile, outputFile, &intOne, &intTwo);
	return 0;
}

void getName(char* firstOrLast, char* name){
    int isValid = 0;
    char buff[MAX_STRING + 1];
    regex_t nameRegex;

	memset(buff, '\0', MAX_STRING);
	memset(name, '\0', MAX_STRING);
    regcomp(&nameRegex, "^[A-Za-z'-]{1,50}$", REG_EXTENDED);

	while (!isValid){
		printf("Enter your %s name (50 or fewer characters)\r\n", firstOrLast);
	
		if (fgets(buff, MAX_STRING, stdin)){
			if(strlen(buff)==MAX_STRING-1){
				discardExtraSTDIN();
			}

			strip(buff);

			if (!regexec(&nameRegex, buff, 0, 0, 0)){
				isValid = 1;
			}
			else{
				printf("%s", "Invalid name\r\n");
			}
		}
		else{
			printf("%s", "Invalid name\r\n");
		}
    }

    strncpy(name, buff, strlen(buff));
	regfree(&nameRegex);
}

void getPassword(char* type, char* password){
    int isValid = 0;
    char buff[MAX_STRING +1];
    regex_t passwordRegex;

	memset(buff, '\0', MAX_STRING);
	memset(password, '\0', MAX_STRING);
	regcomp(&passwordRegex, "^[0-9a-zA-Z]{8,}$", REG_EXTENDED);

	while (!isValid){
		printf("%s password with at least 8 characters, a lowercase, uppercase, and a digit\r\n", type);
	
		if (fgets(buff, MAX_STRING, stdin)){
			if(strlen(buff)==MAX_STRING-1){
				discardExtraSTDIN();
			}

			strip(buff);

			if (!regexec(&passwordRegex, buff, 0, 0, 0)){
				isValid = 1;
			}
			else{
				printf("%s", "Invalid password.\r\n");
			}
		}
		else{
			printf("%s", "Invalid password.\r\n");
		}
    }

    strncpy(password, buff, strlen(buff));
	regfree(&passwordRegex);
}

void getHashedPassword(){
	int isValid = 0;
	char password[MAX_STRING];
	char verifyPassword[sizeof(password)];
	unsigned int hash[4];
	unsigned int verifyHash[4];
	char salt[8];
	int i;
	int saltIndex = 0;
	int length;
	
	srand(clock());
	
	for(i = 0; i < (int)sizeof(salt); ++i){
		salt[i] = (char)((rand()%(MAX_CHAR - 1)) +1);
	}
	
	getPassword("Enter", password);
	length = strlen((char*) password);
	
	for(i = length; i < length + (int)sizeof(salt); ++i){
		password[i] = salt[saltIndex++];
	}
	for(; i < (int)sizeof(password); ++i){
		password[i] = '\0';
	}
	
	md5_vfy((unsigned char*)password, sizeof(password), hash, hash +1, hash +2, hash +3);
	
	for(i = 0; i < (int)sizeof(password); ++i){
		password[i] = '\0';
	}
	
	while(!isValid){
		int verifyLength;
		isValid = 1;
		
		getPassword("Re-enter", verifyPassword);
		verifyLength = strlen((char*)verifyPassword);
		saltIndex = 0;
		
		for(i = length; i < verifyLength + (int)sizeof(salt); ++i){
			verifyPassword[i] = salt[saltIndex++];
		}
		for(; i < (int)sizeof(password); ++i){
			verifyPassword[i] = '\0';
		}
		
		md5_vfy((unsigned char*)verifyPassword, sizeof(password), verifyHash, verifyHash+1, verifyHash+2, verifyHash+3);
		
		for(i = 0; i < 4; ++i){
			if(hash[i] != verifyHash[i]){
				isValid = 0;
			}
		}
		
		if(isValid){
			printf("Password is valid.\r\n");
			break;
		}
		else{
			printf("Password is not valid.\r\n");
		}
	}
}

void getFilename(char* inOrOut, char* name){
	int isValid = 0;
	char buff[MAX_STRING + 1];
	regex_t fileRegex;

	memset(buff, '\0', MAX_STRING);
	memset(name, '\0', MAX_STRING);
	regcomp(&fileRegex, "^[A-Za-z0-9]{1,50}(.txt)$", REG_EXTENDED);

	while(!isValid){
		printf("Enter an %sput file (must be a .txt file in the same directory as the application)\r\n", inOrOut);
		
		if(fgets(buff, MAX_STRING, stdin)){
            if(strlen(buff)==MAX_STRING-1){
                discardExtraSTDIN();
            }

			strip(buff);

			if (!regexec(&fileRegex, buff, 0, 0, 0)){
				isValid = 1;
			}

			else{
				printf("%s", "Invalid filename\r\n");
			}
		}

		else{
			printf("%s", "Invalid filename\r\n");
		}
	}

	strncpy(name, buff, strlen(buff));
    regfree(&fileRegex);
}

void strip(char *array){
	size_t len = strlen(array), x = 0;
	
	if(array == NULL){
		perror("array is null");
		exit(-99);
	}

	while(array[x] != '\0' && x < len){
		if(array[x] == '\r')
		 	array[x] = '\0';

	  	else if(array[x] == '\n')
		 	array[x] = '\0';
		x++;
	}
}

/**
 * Gets input from user to get an Int value. To ensure no crashes it is stored in a long variable.
 * after getting the user input, it is cast to a long value and checked if within the bounds of an
 * int value (-2147483648 to 2147483647).
 * @param theInt
 */
void getInt(long * theInt){
    int isValid = 0;
    char buff[MAX_STRING +1];
    regex_t fileRegex;

    memset(buff,'\0', MAX_STRING);
    regcomp(&fileRegex, "((^[-]?)[1-9][0-9]?){1,10}", REG_EXTENDED);

    while(!isValid){
        printf("Enter an integer value:\r\n");
        if(fgets(buff,MAX_STRING, stdin)) {
            if(strlen(buff)==MAX_STRING-1){
                discardExtraSTDIN();
            }

            if(!regexec(&fileRegex, buff, 0,0,0)){
                *theInt = atol(buff);
                if(*theInt <= 2147483647 && *theInt >= -2147483648){
                    isValid = 1;
                }
                else {
                    printf("Entered value is not within the bounds of -2147483648 to 2147483647.\n");
                }
            }
            else{
                printf("Invalid integer value.\n");
            }
        }
    }
}

/**
 * Takes the parameters gathered from the user input and compiles them into a file specified by the outputFile param,
 * followed by the contents of the inputFile param assuming outputFile is a unique file and inputFile exists.
 * Returns early if outputFile already exists or inputFile does not exist.
 * @param firstName
 * @param lastName
 * @param inputFile
 * @param outputFile
 */
void combiner(char *firstName, char *lastName,char *inputFile, char *outputFile, long* intOne, long* intTwo){
    char c;
	char * cwd = current_directory();
    FILE * input = findFile(inputFile, 1);
    FILE * output = NULL;
    FILE * checkUnique = findFile(outputFile, 1);
	char name[150];

    if(input == NULL) {
        printf("Input file %s was not found in directory %s. FAILED TO CREATE %s.\n",inputFile,cwd, outputFile);
        free(cwd);
        return;
    }

    if(checkUnique==NULL) {
        output = findFile(outputFile, 0);
    }
    else{
        printf("Output file %s already exists. EXITING.\n", outputFile);
        free(cwd);
        return;
    }
	
    strncpy(name, firstName, strlen(firstName));
    strncat(name, " ", 150);
    strncat(name, lastName, 150);

    fprintf(output, "First and last name: %s\n", name);
    fprintf(output, "Integer addition: %ld\n",addInts(*intOne, *intTwo));
    fprintf(output, "Integer multiplication: %ld\n",multInts(*intOne, *intTwo));

    while((c = (char) getc(input)) != EOF){
        fputc(c, output);
    }

    fclose(input);
    fclose(output);
	free(cwd);
}

/**
 * Gets the cwd and puts it in a char*
 * @return char *
 */
char * current_directory() {
    char cwd[1024];
    if (getcwd(cwd, sizeof(cwd)) != NULL) {
        char *cwd_tosend = (char *)malloc(sizeof(char) * sizeof(cwd)+1);
		stpncpy(cwd_tosend, cwd, sizeof(cwd));
        return cwd_tosend;
    }
    else {
        return NULL;
    }
}

/**
 * Tries to open fileName and returns the opened filed pointer or NULL if couldnt be found.
 * @param fileName
 * @param flag
 * @return FILE
 */
FILE *  findFile(char* fileName, int flag){
    FILE * start = NULL;
    if(flag == 1){
        start = fopen(fileName,"r");
    }
    else if(flag == 0){
        start = fopen(fileName,"w+");
    }

    if(start!=NULL){
        return start;
    }

    return NULL;
}

/**
 * Clears extra input from stdin.
 */
void discardExtraSTDIN() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF);
    return;
}


long addInts(long intOne, long intTwo){
    return intOne + intTwo;
}

long multInts(long intOne, long intTwo){
    return intOne * intTwo;
}