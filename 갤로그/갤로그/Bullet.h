#pragma once
#include "Object.h"

class Bullet : public Object
{
public:
	virtual void Init();
	virtual void Update(float dt);
	virtual void Render(float dt);
	virtual void Destroy();

public:
	BOOL m_Remove = FALSE;


public:
	Bullet();
	~Bullet();
};

