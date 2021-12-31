#include "MenuScene.h"

void MenuScene::Init(SceneManager & pSceneManger)
{
}

void MenuScene::Update(float dt)
{
	if (GetAsyncKeyState(VK_RIGHT))
		selectMenu = MENU_GAME_EXIT;
	
	if (GetAsyncKeyState(VK_LEFT))
		selectMenu = MENU_GAME_START;

	if (GetAsyncKeyState(VK_RETURN))
	{
		switch (selectMenu)
		{
		case MENU_GAME_START:
			SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), WHITE);
			System::getInstance()->GetSM()->reserveChangeScene("GameScene");
			break;
		case MENU_GAME_EXIT:
			System::getInstance()->SetExit(TRUE);
			SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), WHITE);
			System::getInstance()->GetDB()->WriteBuffer(0, 0, "게임을 종료합니다. 아무키나 눌러주세요");
			break;
		}
	}

}

void MenuScene::Render(float dt)
{
	DrawMenu();	//메뉴그리기
}

void MenuScene::Destroy()
{
}

void MenuScene::DrawMenu()
{
	SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), BLACK<< 4);


	for (int i = 0; i <= 20; i++)
	{
		for (int j = 0; j <= 60; j += 2)
		{
			System::getInstance()->GetDB()->WriteBuffer(j, i, "　");
		}
	}

	SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), RED);

	for (int i = 2; i <= 60; i += 2)
	{
		System::getInstance()->GetDB()->WriteBuffer(i, 1, "■");

	}
	for (int i = 2; i <= 17; i++)
	{
		System::getInstance()->GetDB()->WriteBuffer(2, i, "■");
		System::getInstance()->GetDB()->WriteBuffer(60, i, "■");
	}

	switch (selectMenu)
	{
	case MENU_GAME_START:
		SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), YELLOW);
		System::getInstance()->GetDB()->WriteBuffer(12, 9, "▶");
		System::getInstance()->GetDB()->WriteBuffer(14, 9, "게임시작");

		SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), WHITE);
		System::getInstance()->GetDB()->WriteBuffer(38, 9, "게임종료");
		break;
	case MENU_GAME_EXIT:
		SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), WHITE);
		System::getInstance()->GetDB()->WriteBuffer(14, 9, "게임시작");

		SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), YELLOW);
		System::getInstance()->GetDB()->WriteBuffer(36, 9, "▶");
		System::getInstance()->GetDB()->WriteBuffer(38, 9, "게임종료");
		break;
	}

	SetConsoleTextAttribute(System::getInstance()->GetDB()->GetBuffer(), RED);
	for (int i = 2; i <= 60; i += 2)
	{
		System::getInstance()->GetDB()->WriteBuffer(i, 17, "■");

	}

}

MenuScene::MenuScene()
{
}

MenuScene::~MenuScene()
{
}
