package com.fileio.exam;

import java.io.FileWriter;

public class Exam05_FileWrite02 {
	public static void main(String[] args) {
		
		String str = "�ǹ߷� ����� �ŴҴ�.\r\n"
				+ "�������� ������\r\n"
				+ "�װ� ���� ���� ������� ������.\r\n"
				+ "�ǹ߷� ����� �ŴҴ�.\r\n"
				+ "�Ӱ� ���� �ϴÿ�\r\n"
				+ "�װ� �Բ� ���� ������� �ø���." ;
		
		try(FileWriter fw = new FileWriter("newKorean.txt");){
			
			fw.write(str);
			fw.flush(); //�ѹ��� �������ִ� ����
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
