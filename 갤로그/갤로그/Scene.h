#pragma once
#include "System.h"
class SceneManager;

class Scene
{
public:
	virtual void Init(SceneManager& pSceneManger) = 0;
	virtual void Update(float dt) = 0;
	virtual void Render(float dt) = 0;
	virtual void Destroy() = 0;

//protected:
//	SceneManager* m_pSceneManger;

};