DefendTheCode: md5.o DefendTheCode.c
	gcc -pedantic -Wall -Wextra -Werror DefendTheCode.c md5.o -o DefendTheCode
md5.o: md5.c
	gcc md5.c -c -o md5.o
run: DefendTheCode
	./DefendTheCode
clean:
	rm -f md5.o