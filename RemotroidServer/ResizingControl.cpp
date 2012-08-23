#include "StdAfx.h"
#include "ResizingControl.h"



CResizingControl::CResizingControl(HWND hwnd):m_hReszingWnd(NULL)
{
}


CResizingControl::~CResizingControl(void)
{
}


//�ʱ� ��ġ�� �޾Ƽ� ������¡�� ������ ����Ѵ�
void CResizingControl::InitRatio(HWND hwnd, int left, int top, int width, int height, 
	int dlgWidth, int dlgHeight)
{
	m_hReszingWnd = hwnd;
	ratio[LEFTRATIO] = (double)((double)left/dlgWidth);
	ratio[TOPRATIO] = (double)((double)top/dlgHeight);
	ratio[WIDTHRATIO] = (double)((double)width/dlgWidth);
	ratio[HEIGHTRATIO] = (double)((double)height/dlgHeight);
	
	::MoveWindow(m_hReszingWnd, left, top, width, height, TRUE);
}


//������ �°� ��Ʈ�� �̵�
void CResizingControl::ResizingControl(int cx, int cy)
{
	if(m_hReszingWnd == NULL)
		return;

	::MoveWindow(m_hReszingWnd, round(ratio[LEFTRATIO]*cx), round(ratio[TOPRATIO]*cy), 
		round(ratio[WIDTHRATIO]*cx), round(ratio[HEIGHTRATIO]*cy), TRUE);
	::RedrawWindow(m_hReszingWnd, NULL, NULL, RDW_INVALIDATE | RDW_UPDATENOW | RDW_ERASE);
}
