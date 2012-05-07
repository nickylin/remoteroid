#include "StdAfx.h"
#include "RecvFile.h"



CRecvFile::CRecvFile(void):m_hRecvFile(NULL)
	, m_iTotalFileSize(0)
	, m_iRecvFileSize(0)
{
	
}


CRecvFile::~CRecvFile(void)
{
}


//���� ����(�̸�, ũ��) ���Ž�..
void CRecvFile::RecvFileInfo(char * data)
{
	char bFileName[FILENAMESIZE+1];
	memset(bFileName, 0, sizeof(bFileName));
	memcpy(bFileName, data, FILENAMESIZE);
	//���� 100 ����Ʈ���� ���� �̸� ����

	char bFileSize[FILESIZESIZE+1];
	memset(bFileSize, 0, sizeof(bFileSize));
	memcpy(bFileSize, data+FILENAMESIZE, FILESIZESIZE);
	//���� 100����Ʈ���� ���� ũ�� ����

	m_iTotalFileSize = atoll(bFileSize);
	//������ ���� ���� ũ��
	memset(m_uniFileName, 0, sizeof(m_uniFileName));
	CUtil::UtfToUni(m_uniFileName, bFileName);

	if(m_hRecvFile)
	{
		CloseHandle(m_hRecvFile);
	}
	m_hRecvFile = CreateFile(m_uniFileName, GENERIC_WRITE, NULL, NULL, CREATE_ALWAYS,
		FILE_ATTRIBUTE_NORMAL, NULL);
	m_iRecvFileSize = 0;
	//���� ���� ���� ũ��
}


//���� ���� ����
void CRecvFile::RecvFileData(char * data, int packetSize)
{
	int iCurrentRecvLen = packetSize - HEADERSIZE;

	DWORD dwWrite;
	WriteFile(m_hRecvFile, data, iCurrentRecvLen, &dwWrite, NULL);
	m_iRecvFileSize += iCurrentRecvLen;
	if(m_iTotalFileSize <= m_iRecvFileSize)
	{
		CloseHandle(m_hRecvFile);
		m_hRecvFile = NULL;
		AfxMessageBox(_T("���� ���� �Ϸ�"));
	}
}


LONGLONG CRecvFile::atoll(char * str)
{
	LONGLONG rVal = 0;
	int sign = 1;

	while (*str && (*str == ' ' || *str == '\t')) str++;
	if (*str == NULL) return(0);

	// ��ȣ ó��
	if (*str == '+' || *str == '-') {
		sign = (*str++ == '+') ? 1 : -1;
	}

	// ������ ����
	while (*str && *str >= '0' && *str <= '9') {
		rVal = rVal * 10 + *str++ - '0';
	}

	return(rVal * sign);
}
