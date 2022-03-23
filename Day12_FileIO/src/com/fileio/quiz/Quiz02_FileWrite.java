package com.fileio.quiz;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class Quiz02_FileWrite {
	public static void main(String[] args) {
		
		String str = "You don't mean to be a problem\r\n"
				+ "You don't mean to cause me pain\r\n"
				+ "You don't mean to do much\r\n"
				+ "But they're one and the same\r\n"
				+ "I don't know where this came from\r\n"
				+ "I thought we were plain sailing\r\n"
				+ "This has taken me aback\r\n"
				+ "And it goes without saying\r\n";
		
		// str�� ��� �����͸� newText.txt ���Ͽ� �����غ�����.
		
		try(FileOutputStream fos = new FileOutputStream("newText.txt", true);){
			// ���ڿ� -> for���� ���鼭 str���� ���� �ϳ��� ���� ����Ʈ �迭�� ���� ��.
//			byte[] strByte = new byte[str.length()];
//			for(int i= 0; i <strByte.length; i++) {
//				strByte[i] = (byte) str.charAt(i);
//			}
//			fos.write(strByte);
			byte[] strByte = str.getBytes();
			fos.write(strByte);
					
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try(FileWriter fw = new FileWriter("newText01.txt");){
			fw.write(str);
			fw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
