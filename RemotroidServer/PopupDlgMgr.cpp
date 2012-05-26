#include "StdAfx.h"
#include "PopupDlgMgr.h"


CPopupDlgMgr::CPopupDlgMgr(void)
{
}


CPopupDlgMgr::~CPopupDlgMgr(void)
{
	m_ptrList.RemoveAll();
}


void CPopupDlgMgr::InsertPopDlg(CPopupDlg * pDlg)
{
	m_ptrList.AddTail((void *)pDlg);
}


void CPopupDlgMgr::RemoveAndMove(CPopupDlg * pDlg)
{
	POSITION oldPos = m_ptrList.Find(pDlg);	
	POSITION pos = oldPos;	

	//�������� �˾� ������ ���� ��������� �Ʒ��� �̵�
	m_ptrList.GetNext(pos);
	while (pos)
	{
		CPopupDlg *pDlg  =(CPopupDlg *)m_ptrList.GetNext(pos);
		if(pDlg != NULL)
			pDlg->PostMessage(WM_MOVEPOPDLG, 0, 0);
	}		

	//�˾� ���̾�αװ� ����� �� ������ delete ���ֱ� ������ ����Ʈ������ �����ϸ� �ȴ�
	m_ptrList.RemoveAt(oldPos);
}
