#include<windows.h>
void win_set(){
	HANDLE  hStdOutHandle;    
	WORD    wOldColorAttrs;  
	CONSOLE_SCREEN_BUFFER_INFO csbiInfo;    
	hStdOutHandle = GetStdHandle(STD_OUTPUT_HANDLE);  
	GetConsoleScreenBufferInfo(hStdOutHandle, &csbiInfo);   
	wOldColorAttrs = csbiInfo.wAttributes;
	SetConsoleTextAttribute(hStdOutHandle, FOREGROUND_GREEN | FOREGROUND_INTENSITY); 	
	//SetConsoleTextAttribute(hStdOutHandle, wOldColorAttrs);
}

