#pragma once
#include "Object.h"
#include "Bullet.h"

class Enemy : public Object
{
public:
	void SetBullet(vector<Bullet>& bullet);

	virtual void Init();
	virtual void Update(float dt);
	virtual void Render(float dt);
	virtual void Destroy();

public:
	BOOL m_Remove = FALSE;

private:
	int mChar[3][3] = {
			{1, 1, 1},
			{0, 0, 1},
			{1, 1, 1} };
	int m_MoveTime = 0;
	vector<Bullet> *m_pBullet;

public:
	Enemy();
	~Enemy();
};

