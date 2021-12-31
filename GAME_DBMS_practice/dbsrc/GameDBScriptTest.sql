SELECT * FROM GAME_USER_ID;
SELECT * FROM GAME_CLASS;
SELECT * FROM GAME_EQUIPMENT;
SELECT * FROM GAME_USER_CHAR;
SELECT * FROM GAME_FIGHT_LOG;

SELECT * FROM GAME_ID_VIEW;
SELECT * FROM GAME_CHAR_VIEW;

DELETE GAME_USER_ID WHERE USER_NUM = 4;
DELETE GAME_USER_CHAR WHERE CHAR_NUM = 3;
DELETE GAME_EQUIPMENT;
-------------------------------------------------

SELECT USER_NUM
FROM GAME_USER_ID
WHERE USER_ID = '������';

SELECT COUNT(USER_ID) FROM GAME_USER_ID WHERE USER_ID = '������';
SELECT COUNT(USER_NUM) FROM GAME_USER_CHAR WHERE USER_NUM = 1;
SELECT CHAR_NUM FROM GAME_USER_CHAR WHERE CHAR_NICKNAME = '�Ǿ';
UPDATE GAME_USER_CHAR SET CHAR_WEAPON = null WHERE CHAR_NUM = 1;

SELECT * FROM GAME_ID_VIEW
WHERE USER_ID = '������'
ORDER BY CHAR_NUM;




---------------

--USER JOIN
INSERT INTO GAME_USER_ID (USER_NUM, USER_ID, USER_PW)
VALUES(USER_SEQ.NEXTVAL, 'TEST_ID4', 'TEST_PW1');
--USER DELETE
DELETE FROM GAME_USER_ID
WHERE USER_NUM = 0;
--USER UPDATE	
UPDATE GAME_USER_ID
SET USER_ACCESS = 'Y'
WHERE USER_NUM = 1;

SELECT USER_NUM 
FROM GAME_USER_ID
WHERE USER_ID = 'TEST_ID3';

--CHAR MAKE
INSERT INTO GAME_USER_CHAR
VALUES(CHAR_SEQ.NEXTVAL, 1, 'TEST_NICK', 0, NULL, 1000, 0, 0, 0, NULL, NULL, NULL, NULL);
INSERT INTO GAME_USER_CHAR (CHAR_NUM, USER_NUM, CHAR_NICKNAME, CLASS_NAME)
VALUES(CHAR_SEQ.NEXTVAL, 1, 'TEST_NICK1', NULL);
INSERT INTO GAME_USER_CHAR (CHAR_NUM, USER_NUM, CHAR_NICKNAME, CLASS_NAME)
VALUES(CHAR_SEQ.NEXTVAL, 1, 'TEST_NICK2', '����');
INSERT INTO GAME_USER_CHAR (CHAR_NUM, USER_NUM, CHAR_EXP, CHAR_NICKNAME, CLASS_NAME)
VALUES(CHAR_SEQ.NEXTVAL, 1, 1500, 'TEST_NICK3', '����');

DELETE FROM GAME_USER_CHAR
WHERE CHAR_NUM = 5;

--CHAR DELETE
DELETE FROM GAME_USER_CHAR
WHERE USER_NUM = 2;



--EQ MAKE
SELECT * FROM GAME_EQUIPMENT;
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, 'ö��', 'W', 1, 'IRON', '����', 0, 0, 5, 0, 0);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, 'ö�ܰ�', 'W', 1, 'IRON', '����', 0, 0, 3, 0.1, 0);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, '����������', 'W', 1, 'IRON', '������', 0, 0, 6, 0, 0);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, '����Ȱ', 'W', 1, 'IRON', '�ü�', 0, 0, 3, 0, 0.1);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, 'ȭ���Ǻ���', 'R', 1, 'IRON', 'ALL', 0, 0, 5, 0, 0);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, '��ī�ο��Ǻ���', 'R', 1, 'IRON', 'ALL', 0, 0, 2, 0, 0.1);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, 'Ȱ���Ǻ���', 'B', 1, 'IRON', 'ALL', 15, 1, 0, 0, 0);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, '�߰����Ǻ���', 'B', 1, 'IRON', 'ALL', 0, 2, 2, 0, 0);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, '�ٶ��Ǻ���', 'G', 1, 'IRON', 'ALL', 0, 0, 0, 0.2, 0);
INSERT INTO GAME_EQUIPMENT
VALUES(EQUIP_SEQ.NEXTVAL, '�ð��Ǻ���', 'G', 1, 'IRON', 'ALL', 0, 0, 0, 0, 0.2);

--CLASS MAKE
SELECT * FROM GAME_CLASS;
INSERT INTO GAME_CLASS
VALUES('����', 120, 6, 10, 0.5, 20, 1, 4, 0, 1, 0);
INSERT INTO GAME_CLASS
VALUES('����', 100, 5, 5, 0.1, 17, 1, 4.3, 0.01, 1.3, 0.02);
INSERT INTO GAME_CLASS
VALUES('������', 80, 3, 3, 0.1, 30, 1.5, 3.9, 0, 0.6, 0);
INSERT INTO GAME_CLASS
VALUES('�ü�', 90, 4, 5, 0.1, 15, 1.5, 4.1, 0, 1.2, 0);
