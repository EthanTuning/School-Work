#ifndef _MD5_H_
#define _MD5_H_

#define uint unsigned int

void md5_vfy(unsigned char* data, uint length, uint *a1, uint *b1, uint *c1, uint *d1);
void md5_to_ints(unsigned char* md5, uint *r0, uint *r1, uint *r2, uint *r3);
#endif