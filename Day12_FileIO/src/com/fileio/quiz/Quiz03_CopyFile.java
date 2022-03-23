package com.fileio.quiz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Quiz03_CopyFile {
	
	public static void copyFile(String from, String to) { // ���ϸ��� �Ű������� �޾Ƽ� ����ϱ�
		try(FileReader fr = new FileReader(from);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(to);){
				
				String line = "";
				while((line = br.readLine()) != null) {
					fw.write(line + "\n");
				}
				fw.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
	}
	
	public static void main(String[] args) {
		copyFile("A.txt", "B.txt"); // ���ϸ��� �־ ���� -> �󸶵��� �ٲ� �� ����
		//A.txt ������ �����ؼ� B.txt ���Ϸ� ����� ������.
		// A.txt�� �����͸� �Է�
		// -> �� �����͸� B.txt ���Ϸ� ���
		// Reader Writer -> ����
		
		
//		try(FileInputStream fis = new FileInputStream("A.txt");
//		    FileOutputStream fos =  new FileOutputStream("B.txt");){
//			
//			byte[] temp = new byte[1024];
//			
//			fis.read(temp);
//			System.out.println(new String(temp));
//			
//			fos.write(temp);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
