#include "System.h"
#include "SceneDefine.h"

System* System::_instance = nullptr;
void Init();

int main()
{	
	//씬매니져/ 더블버퍼 생성, 초기화
	Init();
	//게임 루프문
	while (!System::getInstance()->GetExit())
	{
		System::getInstance()->GetDB()->ClearBuffer();

		System::getInstance()->GetSM()->Render(DELTATIME);
		System::getInstance()->GetSM()->Update(DELTATIME);

		System::getInstance()->GetDB()->FlippingBuffer();
	}

	//프로그램 종료
	System::getInstance()->Destroy();
	return 0;
}

void Init()
{
	//시스템 매니져 생성, 더블버퍼 생성/초기화
	System::getInstance()->GetDB()->CreateBuffer(CONSOLE_MAX_WIDTH, CONSOLE_MAX_HEIGHT);
	
	//씬매니져 생성/초기화
	System::getInstance()->GetSM()->RegisterScene("MenuScene", new MenuScene);	//메뉴씬 생성
	System::getInstance()->GetSM()->RegisterScene("GameScene", new GameScene);	//게임씬 생성

	//씬 등록
	System::getInstance()->GetSM()->reserveChangeScene("MenuScene");	//메뉴씬 설정
}