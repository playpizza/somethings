#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string>
#include <map>
#include <vector>
#include <Windows.h>
#include <iostream>

using namespace std;

#define DELTATIME	0	//��Ÿ Ÿ�� (ȥ�ڼ� �غ���)
#define CONSOLE_MAX_WIDTH	100	//�ܼ� ����ũ��
#define CONSOLE_MAX_HEIGHT	30	//�ܼ� ����ũ��

//�ܼ� ����ǥ
#define BLACK	0x00
#define BLUE	0x01
#define GREEN	0x02
#define CYAN	0x03
#define RED	0x04
#define MAGENTA	0x05
#define BROWN	0x06
#define LIGHTGRAY	0x07
#define DARKGRAY	0x08
#define LIGHTBLUE	0x09
#define LIGHTGREEN	0x0A
#define LIGHTCYAN	0x0B
#define LIGHTRED	0x0C
#define LIGHTMAGENTA	0x0D
#define YELLOW	0x0E
#define WHITE	0x0F

//���� �޴�
#define MENU_GAME_START 0x00
#define MENU_GAME_EXIT 0x01