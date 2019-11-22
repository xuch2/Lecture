#ifndef NEON_IMAGEVIEW_H_
#define NEON_IMAGEVIEW_H_

void ImageProcessC(unsigned char* bufIn, unsigned char* bufOut, unsigned char* bufres, int nWidth, int nHeight, int rate);
void ImageProcessNeon(unsigned char* bufIn, unsigned char* bufOut, unsigned char* bufres , int nWidth, int nHeight, int rate);

#endif /* NEON_IMAGEVIEW_H_ */