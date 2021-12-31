#include "System.h"
#include "SceneDefine.h"

System* System::_instance = nullptr;
void Init();

int main()
{	
	//���Ŵ���/ ������� ����, �ʱ�ȭ
	Init();
	//���� ������
	while (!System::getInstance()->GetExit())
	{
		System::getInstance()->GetDB()->ClearBuffer();

		System::getInstance()->GetSM()->Render(DELTATIME);
		System::getInstance()->GetSM()->Update(DELTATIME);

		System::getInstance()->GetDB()->FlippingBuffer();
	}

	//���α׷� ����
	System::getInstance()->Destroy();
	return 0;
}

void Init()
{
	//�ý��� �Ŵ��� ����, ������� ����/�ʱ�ȭ
	System::getInstance()->GetDB()->CreateBuffer(CONSOLE_MAX_WIDTH, CONSOLE_MAX_HEIGHT);
	
	//���Ŵ��� ����/�ʱ�ȭ
	System::getInstance()->GetSM()->RegisterScene("MenuScene", new MenuScene);	//�޴��� ����
	System::getInstance()->GetSM()->RegisterScene("GameScene", new GameScene);	//���Ӿ� ����

	//�� ���
	System::getInstance()->GetSM()->reserveChangeScene("MenuScene");	//�޴��� ����
}