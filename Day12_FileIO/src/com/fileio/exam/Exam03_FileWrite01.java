package com.fileio.exam;

import java.io.FileOutputStream;

public class Exam03_FileWrite01 {
	public static void main(String[] args) {
		
		// ���α׷� ���忡�� ������ ����ϴ� ���̱� ������ OutputStream �ʿ�
		
		try(FileOutputStream fos = new FileOutputStream("output.txt", true);){//������ ������ ���
			// write ��� �޼��� �Ƚ��൵ file �� ������ -> ���� �ڵ忡�� �̹� ������ �����Ʊ� ����
			//fos.write('B');
			//write : ������ ���Ͽ� ���ڸ� ���ִ� �޼���
			//���� ������ ���Ͽ� �̾ ������ �ۼ��ϰ� �ʹٸ�(�����X) true ���ڰ� 
			
			//�������� ������ �迭
			byte [] fileCotents = {'a', 'b', 'c', 'd'};
			fos.write(fileCotents);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
