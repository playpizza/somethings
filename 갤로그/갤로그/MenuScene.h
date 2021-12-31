#pragma once
#include "Scene.h"

class MenuScene : public Scene
{
public:
	virtual void Init(SceneManager& pSceneManger);
	virtual void Update(float dt);
	virtual void Render(float dt);
	virtual void Destroy();

	void DrawMenu();

private:
	WORD selectMenu = MENU_GAME_START;	//메뉴 선택

public:
	MenuScene();
	~MenuScene();
};

