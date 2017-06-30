#include <fileTest.h>

int main(){

	FILE *fp;
	FILE *fp1;

	write(fp);
	read(fp);
	append(fp);
	read(fp);
	writeEmpty(fp1);
	checkEmpty(fp1);

return 0;
}

void read(FILE *fp){
	fp = fopen("file.txt", "r");
	printf("\nContents of the file....\n");
	char ch;

	do{
		ch = fgetc(fp);
		printf("%c", ch);
 	}while(ch != EOF);

	fseek(fp, -1, SEEK_END);
	fread(&ch, 1, 1, fp);

	printf("\nChecking for carriage return....");
	if(ch == '\r'){
		printf("\nCarriage return detected.\n");
	}
	else{
		printf("\nCarriage return not detected.\n");
	}
	fclose(fp);
}

void write(FILE *fp){
	fp = fopen("file.txt", "w");
	fputs("Hello\n", fp);
	fclose(fp);
}

void append(FILE *fp){
	fp = fopen("file.txt", "a");

	printf("\nSearching for SPI....");

	if(ftell(fp) == 0){
		printf("\nThe SPI is at the beginning of the file.\n");
	}
	else{
		printf("\nThe SPI is at the end of the file.\n");
	}

	fseek(fp, 0, SEEK_SET);
	fputs("Goodbye CSCD240\n", fp);
	fclose(fp);
}

void writeEmpty(FILE *fp){
	fp = fopen("file1.txt", "w");
	fputs("", fp);
	fclose(fp);
}

void checkEmpty(FILE *fp){
	fp = fopen("file.txt", "r");

	if(fp == NULL){
		perror("\nOS does not allow for an empty file to exist after being closed");
	}
	else{
		printf("\nOS does allow for an empty file to exist after being closed.\n");
	}
	fclose(fp);
}
