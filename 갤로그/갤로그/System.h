#pragma once
#include "GameDefine.h"
#include "SceneManager.h"
#include "DoubleBuffer.h"

class System	//singleton����
{
public:
	static System* _instance;
	static System* getInstance()
	{
		if (_instance == nullptr)
			_instance = new System;
		return _instance;
	}

public:
	void SetExit(BOOL done) { gameExit = done; }
	BOOL GetExit() { return gameExit; }

	void SetCollision(BOOL done) { gameCollision = done; }
	BOOL GetCollision() { return gameCollision; }

	void SetScore(SHORT done) { gameScore = done; }
	SHORT GetScore() { return gameScore; }

	void Destroy()
	{
		if (m_pSM != nullptr)
			delete m_pSM;
		if (m_pDB != nullptr)
			delete m_pDB;
		if (_instance != nullptr)
			delete _instance;
	}

	DoubleBuffer* GetDB()
	{
		if (m_pDB == nullptr)
			m_pDB = new DoubleBuffer;
		return m_pDB;
	}

	SceneManager* GetSM()
	{
		if (m_pSM == nullptr)
			m_pSM = new SceneManager;
		return m_pSM;
	}

private:
	SceneManager* m_pSM = nullptr;	//�� �Ŵ���
	DoubleBuffer* m_pDB = nullptr;	//�������

	BOOL gameExit = FALSE;	//���� ����
	BOOL gameCollision = FALSE;	//���� ����
	SHORT gameScore = 0;	//���� ����

};