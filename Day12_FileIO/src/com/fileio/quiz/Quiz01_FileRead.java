package com.fileio.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class Quiz01_FileRead {
	public static void main(String[] args) {
		
		// ���ۿ��� ���ϴ� ª�� ����� �� �ó�, ����, ����, �Ҽ� �ϳ��� ���ؼ�
		// ������Ʈ ���� ���� txt ���Ϸ� ���� -> �� ������ �о�鿩 �ַܼ� ����ϱ�
		
		File newFile = new File("Crying Over You.txt");
		if(!newFile.exists()) {
			try {
				newFile.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		try(FileInputStream lyrics = new FileInputStream("Crying Over You.txt");) {
			byte[] file = new byte[1024];
			lyrics.read(file);
			for(byte f : file) {
				System.out.print((char)f);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		// File Reader / BufferedReader�� ����ؼ� �б�� ����
		
		try(FileReader lyric = new FileReader("Crying Over You.txt");
				BufferedReader br = new BufferedReader(lyric);){
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
