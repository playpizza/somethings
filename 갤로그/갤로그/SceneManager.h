#pragma once
#include "GameDefine.h"

class Scene;

class SceneManager
{
public:
	void RegisterScene(const std::string& sceneName, Scene* scene);
	void reserveChangeScene(const std::string& sceneName);

public:
	void Update(float dt);
	void Render(float dt);

private:
	std::map<std::string, Scene*> m_SceneContainer;

	Scene* m_ReservedScene = nullptr;
	Scene* m_CurrentScene = nullptr;

public:
	SceneManager();
	~SceneManager();
};

