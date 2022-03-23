package com.fileio.exam;

import java.io.FileInputStream;

public class Exam02_FileRead01 {
	public static void main(String[] args) {
		
		// try ~ with ~ resource
		// try(��ü �ڵ��ݳ��� ���ְ� ���� ������) -> try���� ������ �˾Ƽ� ��ü�� �ݳ�
		try(FileInputStream fis = new FileInputStream("test.txt")){
			
			// byte������ �ϳ��� ���� = ���ڿ����ƽ�Ű�ڵ�� �о�鿩��
			//System.out.println(fis.read());
			/*System.out.println((char)fis.read());
			System.out.println((char)fis.read());
			System.out.println((char)fis.read());*/
			
			// �����͸� �ѹ��� �о����.
			byte[] fileContents = new byte[100];
			fis.read(fileContents);
			// test.txt ���Ϸκ��� �о�鿩�� �����͸� fileContents �迭�ȿ� ��� ��� ��.
			
			for(byte b : fileContents) {
				System.out.print((char)b + " ");
			}
			
			System.out.println(new String(fileContents));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// ���� �Է� -> Stream -> InputStream
//		FileInputStream fis = null;
//		try {
//			// ���ϰ� ���õ� ��ü �ν��Ͻ��� ������� ������ ��ü �ݳ��� �������� ����� ��
//			// �ݳ� ����� ���ϸ� �������� ���� ���� ���� �������� �ʴ� ��Ȳ�� �߻��� �� ����
//			fis = new FileInputStream("test.txt");
//			
//			 
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally{//���࿡ try�� ���ʿ��� ���ܰ� �߻��ϴ��� finally ������ �ڵ�� ������ ���� ��.
//			try {
//				fis.close(); // close() ��� �޼��尡 �ݳ��ϰڴٴ� ������ ��
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
	
	}

}
