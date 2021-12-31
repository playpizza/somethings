#pragma once
#include <conio.h>
#include <CoreWindow.h>

class DoubleBuffer
{
public:
	HANDLE GetBuffer();		//버퍼를 구분하기 위한 것

	void CreateBuffer(const int& width, const int& height);	//버퍼생성
	void WriteBuffer(int x, int y, const char *string);	//버퍼쓰기
	void FlippingBuffer();		//버퍼 전환
	void ClearBuffer();			//버퍼 비우기
	void DestoryBuffer();		//버퍼 해제

	bool CloseHandel(HANDLE& handle);	//핸들 처리

private:
	int m_BufferIndex;		//버퍼 인덱스
	HANDLE m_hBuffer[2];	//버퍼 핸들러

public:
	DoubleBuffer();
	~DoubleBuffer();
};

