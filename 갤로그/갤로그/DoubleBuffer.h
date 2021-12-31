#pragma once
#include <conio.h>
#include <CoreWindow.h>

class DoubleBuffer
{
public:
	HANDLE GetBuffer();		//���۸� �����ϱ� ���� ��

	void CreateBuffer(const int& width, const int& height);	//���ۻ���
	void WriteBuffer(int x, int y, const char *string);	//���۾���
	void FlippingBuffer();		//���� ��ȯ
	void ClearBuffer();			//���� ����
	void DestoryBuffer();		//���� ����

	bool CloseHandel(HANDLE& handle);	//�ڵ� ó��

private:
	int m_BufferIndex;		//���� �ε���
	HANDLE m_hBuffer[2];	//���� �ڵ鷯

public:
	DoubleBuffer();
	~DoubleBuffer();
};

