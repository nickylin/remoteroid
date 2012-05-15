package org.secmem.remoteroid.network;

import java.io.*;

import android.util.*;

public class PacketReceiver implements Runnable{
	private byte [] 		recvBuffer 			= new byte[CONS.MAXPACKETSIZE * 2];
	private byte [] 		header 				= new byte[CONS.HEADERSIZE];
	private byte [] 		data 				= new byte[CONS.MAXPACKETSIZE-CONS.HEADERSIZE];
	private byte [] 		bPacketSize 		= new byte[CONS.PACKETSIZE];
	private byte [] 		bOPCode 			= new byte[CONS.OPCODESIZE];
	private FileReceiver	fileReceiver		= new FileReceiver();
	private FileSender		fileSender			= null;

	private int 		iCurrentBufferPos 	= 0;
	private InputStream in 					= null;
	
	public PacketReceiver(InputStream in, FileSender fileSender){
		this.in = in;
		this.fileSender = fileSender;
	}

	
	private int ByteToInt(byte [] data){
		int result = 0;
		for(int i=0; i<data.length; i++){
			if(data[i] == ' ')
				continue;
			result = result * 10 + (data[i]-'0');
		}
		return result;
	}
	
	/**
	 * ��Ŷ ����κ��� �������� ��Ŷ�� ũ�⸦ ����
	 * @return
	 */
	private int GetPacketSize(byte [] packet){
		 System.arraycopy(packet, CONS.OPCODESIZE, bPacketSize, 0, CONS.PACKETSIZE);
				 
		 return ByteToInt(bPacketSize);
	}
	
	private int GetOPCode(byte [] packet){
		System.arraycopy(packet, 0, bOPCode, 0, CONS.OPCODESIZE);
		
		return ByteToInt(bOPCode);
	}
	
	/**
	 * input stream���� ���� ���۷� �ִ� 4096�� ��
	 */
	private int RecvBuffer() throws IOException{		
		int iRecvLen = in.read(recvBuffer, iCurrentBufferPos, CONS.MAXPACKETSIZE);		
		
		if(iRecvLen > 0){
			iCurrentBufferPos += iRecvLen;			
		}
		return iRecvLen;
	}
	
	private boolean GetPacket(){
		
		//��� ũ�⸸ŭ �������� ���Ѱ�� �ҿ����� ��
		if(iCurrentBufferPos < CONS.HEADERSIZE){			
			return false;
		}
		
		int iPacketSize = GetPacketSize(recvBuffer);		
		
		//����� ��ϵ� ��Ŷ�� �� ũ�⸸ŭ �������� ����
		if(iPacketSize > iCurrentBufferPos){
			return false;
		}		
		
		//���� ���ۿ��� ����� ������ ��	
		System.arraycopy(recvBuffer, 0, header, 0, CONS.HEADERSIZE);		
		System.arraycopy(recvBuffer, CONS.HEADERSIZE, data, 0, iPacketSize-CONS.HEADERSIZE);
		iCurrentBufferPos -= iPacketSize;		
		System.arraycopy(recvBuffer, iPacketSize, recvBuffer, 0, iCurrentBufferPos);		
		return true;
	}
	
	public void run(){
		while(true){
			try {
				int iRecvLen = RecvBuffer();
				if(iRecvLen < 0){
					// ���� ��
					Log.i("exception", "<0");
					break;
				}
				while(GetPacket()){
					int iOPCode = GetOPCode(header);
					int iPacketSize = GetPacketSize(header);	
					
					switch(iOPCode){
					case CONS.OPCODE.OP_SENDFILEINFO:
						fileReceiver.RecvFileInfo(data);						
						break;
					case CONS.OPCODE.OP_SENDFILEDATA:
						fileReceiver.RecvFileData(data, iPacketSize);
						break;		
					case CONS.OPCODE.OP_REQFILEDATA:
						fileSender.SendFileData();
						break;
					case CONS.OPCODE.OP_REQFILEINFO:						
						fileSender.SendFileInfo();
						break;
					}
				}
			} catch (IOException e) {	
				Log.i("exception", "recv thread : "+e.getMessage());
				fileReceiver.CloseFile();	//���� �������̿��ٸ� ����
				NetworkModule.getInstance().CloseSocket();				
				break;
			}
		}
	}	
}
