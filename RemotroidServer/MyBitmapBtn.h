#pragma once


// CMyBitmapBtn

class CMyBitmapBtn : public CBitmapButton
{
	DECLARE_DYNAMIC(CMyBitmapBtn)

public:
	CMyBitmapBtn();
	virtual ~CMyBitmapBtn();	
	virtual VOID SetHoverBitmapID(IN UINT nIDBitmapResourceHover);

protected:
	DECLARE_MESSAGE_MAP()

protected:	
	BOOL				m_bMouseHover;
	TRACKMOUSEEVENT		m_stTrackMouse;
	UINT				m_nIDBitmapResourceHover;
	CBitmap				m_cBitmapHover;

public:
	virtual void DrawItem(LPDRAWITEMSTRUCT /*lpDrawItemStruct*/);
	afx_msg BOOL OnEraseBkgnd(CDC* pDC);
	afx_msg void OnMouseMove(UINT nFlags, CPoint point);	
	afx_msg int OnCreate(LPCREATESTRUCT lpCreateStruct);
	afx_msg void OnMouseLeave();	

	afx_msg void OnSetFocus(CWnd* pOldWnd);
};


