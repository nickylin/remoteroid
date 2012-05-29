#include "StdAfx.h"
#include "Util.h"


CUtil::CUtil(void)
{
}


CUtil::~CUtil(void)
{
}


int CUtil::GetOpCode(char * packet)
{
	char bOPCode[OPCODESIZE+1];
	memset(bOPCode, 0, sizeof(bOPCode));
	memcpy(bOPCode, packet, OPCODESIZE);
	return atoi(bOPCode);
}


int CUtil::GetPacketSize(char * packet)
{
	char bPacketSize[TOTALSIZE+1];
	memset(bPacketSize, 0, sizeof(bPacketSize));
	memcpy(bPacketSize, packet+OPCODESIZE, TOTALSIZE);
	return atoi(bPacketSize);
}


void CUtil::UniToUtf(TCHAR * uni, char * utf)
{
	int nLen = WideCharToMultiByte(CP_UTF8, 0, uni, _tcslen(uni)+1, NULL, NULL, NULL, NULL);
	WideCharToMultiByte(CP_UTF8, 0, uni, _tcslen(uni)+1, utf, nLen, NULL, NULL);
}


void CUtil::UtfToUni(TCHAR * uni, char * utf)
{
	int nLen = MultiByteToWideChar(CP_UTF8, 0, utf, strlen(utf)+1, NULL, NULL);
	MultiByteToWideChar(CP_UTF8, 0, utf, strlen(utf)+1, uni, nLen);
}

//Ʈ���̷� �̵��ϴ� �ִϸ��̼�
void CUtil::AniMinimizeToTray(HWND hwnd)
{
	RECT rectTo, rectFrom;
	::GetWindowRect(hwnd, &rectFrom);

	GetTrayWndRect(&rectTo);
	DrawAnimatedRects(hwnd, IDANI_CAPTION, &rectFrom, &rectTo);
}


void CUtil::GetTrayWndRect(RECT * pRect)
{
	HWND hwndTaskBar=::FindWindow(_T("Shell_TrayWnd"), NULL);
	if (hwndTaskBar){
		HWND hwndTray=::FindWindowEx(hwndTaskBar, NULL, _T("TrayNotifyWnd"), NULL);
		if (hwndTray)
			::GetWindowRect(hwndTray, pRect);
		else{
			//tray�κ��� ��ã���� task���� �������̸� �׷��ٰ� �ϰ� ����.
			::GetWindowRect(hwndTaskBar, pRect);
			pRect->left=pRect->right-20;
			pRect->top=pRect->bottom-20;
		}
	}
	else{
		//task�ٸ� ��ã���� �׳� ȭ�� �ϴܺ�
		int nWidth = GetSystemMetrics(SM_CXSCREEN);
		int nHeight = GetSystemMetrics(SM_CYSCREEN);
		SetRect(pRect, nWidth-40, nHeight-20, nWidth, nHeight);
	}
}


void CUtil::AniMaximiseFromTray(HWND hwnd)
{
	RECT rectFrom;
	GetTrayWndRect(&rectFrom);
	WINDOWPLACEMENT wndpl;
	::GetWindowPlacement(hwnd, &wndpl);    //�ּ�ȭ�� ���¿��� ������ GetWindowRect�� �ȵ�

	DrawAnimatedRects(hwnd, IDANI_CAPTION, &rectFrom, &wndpl.rcNormalPosition);
}


void CUtil::SetHanEngMode(HWND hFocusWnd)
{
	HIMC hImc;
	DWORD dwConv, dwSent, dwTemp;	
	hImc = ImmGetContext(hFocusWnd);
	if(hImc != NULL)
	{
		ImmGetConversionStatus(hImc, &dwConv, &dwSent);
		dwTemp = dwConv & ~IME_CMODE_LANGUAGE;
		dwTemp |= IME_CMODE_ALPHANUMERIC;
		dwConv = dwTemp;
		ImmSetConversionStatus(hImc,dwConv,dwSent);
		ImmReleaseContext(hFocusWnd, hImc);
	}
}
