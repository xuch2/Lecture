#include <arm_neon.h>
//#include <omp.h>  // OpenMP 사용을 위한 헤더 파일
#include "neon_imageview.h"

void ImageProcessNeon(unsigned char* bufIn, unsigned char* bufOut, unsigned char* bufres , int nWidth, int nHeight, int rate)
{
	int j = 0, i = 0;
	int nWidth4 = nWidth*4;
	float inRate[10], outRate[10];

	inRate[0] = 0; inRate[1] = 0.1; inRate[2] = 0.2; inRate[3] = 0.3; inRate[4] = 0.4; inRate[5] = 0.5; inRate[6] = 0.6; inRate[7] = 0.7; inRate[8] = 0.8; inRate[9] = 1.0;
	outRate[0] = 1; outRate[1] = 0.8; outRate[2] = 0.7; outRate[3] = 0.6; outRate[4] = 0.5; outRate[5] = 0.4; outRate[6] = 0.3; outRate[7] = 0.2; outRate[8] = 0.1; outRate[9] = 0.0;

	float fin = inRate[rate];
	float fout = outRate[rate];

	float32x4_t redoffsetIn = vmovq_n_f32(fin);
	float32x4_t greenoffsetIn = vmovq_n_f32(fin);
	float32x4_t blueoffsetIn = vmovq_n_f32(fin);

	float32x4_t redoffsetOut = vmovq_n_f32(fout);
	float32x4_t greenoffsetOut = vmovq_n_f32(fout);
	float32x4_t blueoffsetOut = vmovq_n_f32(fout);

	uint8x8x4_t argbIn, argbOut, dest;
	uint8x8_t In, Out;
	uint16x8_t load;
	uint16x4_t high, low;
	uint32x4_t inthi, intlo;
	float32x4_t floathi, floatlo;

//	omp_set_num_threads(8);
//#pragma omp parallel for
	for(j =0; j < nHeight; j++){
		for(i =0; i < nWidth4; i+=32){
			argbIn = vld4_u8(&bufIn[i+j*nWidth4]); // lena image
			argbOut = vld4_u8(&bufOut[i+j*nWidth4]); // and image

			//lenna red
			load = vmovl_u8(argbIn.val[0]);
			uint16x4_t high = vget_high_u16(load);
			uint16x4_t low = vget_low_u16(load);
			uint32x4_t inthi =  vmovl_u16(high);
			uint32x4_t intlo =  vmovl_u16(low);
			float32x4_t floathi = vcvtq_f32_u32(inthi);
			float32x4_t floatlo = vcvtq_f32_u32(intlo);
			floathi = vmulq_f32(floathi, redoffsetIn);
			floatlo = vmulq_f32(floatlo, redoffsetIn);
			inthi = vcvtq_u32_f32(floathi);
			intlo = vcvtq_u32_f32(floatlo);
			high =  vmovn_u32(inthi);
			low =  vmovn_u32(intlo);
			load = vcombine_u16(low, high);
			In = vmovn_u16(load);
			//and red
			load = vmovl_u8(argbOut.val[0]);
			high = vget_high_u16(load);
			low = vget_low_u16(load);
			inthi =  vmovl_u16(high);
			intlo =  vmovl_u16(low);
			floathi = vcvtq_f32_u32(inthi);
			floatlo = vcvtq_f32_u32(intlo);
			floathi = vmulq_f32(floathi, redoffsetOut);
			floatlo = vmulq_f32(floatlo, redoffsetOut);
			inthi = vcvtq_u32_f32(floathi);
			intlo = vcvtq_u32_f32(floatlo);
			high =  vmovn_u32(inthi);
			low =  vmovn_u32(intlo);
			load = vcombine_u16(low, high);
			Out = vmovn_u16(load);
			//red fade in/out
			dest.val[0] = vadd_u8(In,Out);

			//lenna green
			load = vmovl_u8(argbIn.val[1]);
			high = vget_high_u16(load);
			low = vget_low_u16(load);
			inthi =  vmovl_u16(high);
			intlo =  vmovl_u16(low);
			floathi = vcvtq_f32_u32(inthi);
			floatlo = vcvtq_f32_u32(intlo);
			floathi = vmulq_f32(floathi, greenoffsetIn);
			floatlo = vmulq_f32(floatlo, greenoffsetIn);
			inthi = vcvtq_u32_f32(floathi);
			intlo = vcvtq_u32_f32(floatlo);
			high =  vmovn_u32(inthi);
			low =  vmovn_u32(intlo);
			load = vcombine_u16(low, high);
			In = vmovn_u16(load);
			//and green
			load = vmovl_u8(argbOut.val[1]);
			high = vget_high_u16(load);
			low = vget_low_u16(load);
			inthi =  vmovl_u16(high);
			intlo =  vmovl_u16(low);
			floathi = vcvtq_f32_u32(inthi);
			floatlo = vcvtq_f32_u32(intlo);
			floathi = vmulq_f32(floathi, greenoffsetOut);
			floatlo = vmulq_f32(floatlo, greenoffsetOut);
			inthi = vcvtq_u32_f32(floathi);
			intlo = vcvtq_u32_f32(floatlo);
			high =  vmovn_u32(inthi);
			low =  vmovn_u32(intlo);
			load = vcombine_u16(low, high);
			Out = vmovn_u16(load);
			//green fade in/out
			dest.val[1] = vadd_u8(In,Out);

			//lenna blue
			load = vmovl_u8(argbIn.val[2]);
			high = vget_high_u16(load);
			low = vget_low_u16(load);
			inthi =  vmovl_u16(high);
			intlo =  vmovl_u16(low);
			floathi = vcvtq_f32_u32(inthi);
			floatlo = vcvtq_f32_u32(intlo);
			floathi = vmulq_f32(floathi, blueoffsetIn);
			floatlo = vmulq_f32(floatlo, blueoffsetIn);
			inthi = vcvtq_u32_f32(floathi);
			intlo = vcvtq_u32_f32(floatlo);
			high =  vmovn_u32(inthi);
			low =  vmovn_u32(intlo);
			load = vcombine_u16(low, high);
			In = vmovn_u16(load);
			//and blue
			load = vmovl_u8(argbOut.val[2]);
			high = vget_high_u16(load);
			low = vget_low_u16(load);
			inthi =  vmovl_u16(high);
			intlo =  vmovl_u16(low);
			floathi = vcvtq_f32_u32(inthi);
			floatlo = vcvtq_f32_u32(intlo);
			floathi = vmulq_f32(floathi, blueoffsetOut);
			floatlo = vmulq_f32(floatlo, blueoffsetOut);
			inthi = vcvtq_u32_f32(floathi);
			intlo = vcvtq_u32_f32(floatlo);
			high =  vmovn_u32(inthi);
			low =  vmovn_u32(intlo);
			load = vcombine_u16(low, high);
			Out = vmovn_u16(load);
			dest.val[2] = vadd_u8(In,Out);

			//lenna blue
			load = vmovl_u8(argbIn.val[3]);
			high = vget_high_u16(load);
			low = vget_low_u16(load);
			inthi =  vmovl_u16(high);
			intlo =  vmovl_u16(low);
			floathi = vcvtq_f32_u32(inthi);
			floatlo = vcvtq_f32_u32(intlo);
			floathi = vmulq_f32(floathi, blueoffsetIn);
			floatlo = vmulq_f32(floatlo, blueoffsetIn);
			inthi = vcvtq_u32_f32(floathi);
			intlo = vcvtq_u32_f32(floatlo);
			high =  vmovn_u32(inthi);
			low =  vmovn_u32(intlo);
			load = vcombine_u16(low, high);
			In = vmovn_u16(load);
			//and blue
			load = vmovl_u8(argbOut.val[3]);
			high = vget_high_u16(load);
			low = vget_low_u16(load);
			inthi =  vmovl_u16(high);
			intlo =  vmovl_u16(low);
			floathi = vcvtq_f32_u32(inthi);
			floatlo = vcvtq_f32_u32(intlo);
			floathi = vmulq_f32(floathi, blueoffsetOut);
			floatlo = vmulq_f32(floatlo, blueoffsetOut);
			inthi = vcvtq_u32_f32(floathi);
			intlo = vcvtq_u32_f32(floatlo);
			high =  vmovn_u32(inthi);
			low =  vmovn_u32(intlo);
			load = vcombine_u16(low, high);
			Out = vmovn_u16(load);
			dest.val[3] = vadd_u8(In,Out);

			vst4_u8(&bufres[i+j*nWidth4],dest);
		}
	}
}

void ImageProcessC(unsigned char* bufIn, unsigned char* bufOut, unsigned char* bufres , int nWidth, int nHeight, int rate)
{
	int j = 0, i = 0;
	int nWidth4 = nWidth*4;
	int nInIndex = 0, nOutIndex = 0;
	float inRate[10], outRate[10];

	inRate[0] = 0; inRate[1] = 0.1; inRate[2] = 0.2; inRate[3] = 0.3; inRate[4] = 0.4; inRate[5] = 0.5; inRate[6] = 0.6; inRate[7] = 0.7; inRate[8] = 0.8; inRate[9] = 1.0;
	outRate[0] = 1; outRate[1] = 0.8; outRate[2] = 0.7; outRate[3] = 0.6; outRate[4] = 0.5; outRate[5] = 0.4; outRate[6] = 0.3; outRate[7] = 0.2; outRate[8] = 0.1; outRate[9] = 0.0;

	float fin = inRate[rate];
	float fout = outRate[rate];

	for(j =0; j < nHeight; j++){
		for(i =0; i < nWidth4; i+=4){
			float fbufferIn = bufIn[i+j*nWidth4+0];
			float fbufferOut = bufOut[i+j*nWidth4+0];
			bufres[i+j*nWidth4+0] = (unsigned char)((fbufferIn* fin) + (fbufferOut*fout));

			fbufferIn = bufIn[i+j*nWidth4+1];
			fbufferOut = bufOut[i+j*nWidth4+1];
			bufres[i+j*nWidth4+1] = (unsigned char)((fbufferIn* fin) + (fbufferOut*fout));

			fbufferIn = bufIn[i+j*nWidth4+2];
			fbufferOut = bufOut[i+j*nWidth4+2];
			bufres[i+j*nWidth4+2] = (unsigned char)((fbufferIn* fin) + (fbufferOut*fout));

			fbufferIn = bufIn[i+j*nWidth4+3];
			fbufferOut = bufOut[i+j*nWidth4+3];
			bufres[i+j*nWidth4+3] = (unsigned char)((fbufferIn* fin) + (fbufferOut*fout));
		}
	}
}