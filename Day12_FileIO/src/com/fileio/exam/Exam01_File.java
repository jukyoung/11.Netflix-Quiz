package com.fileio.exam;

import java.io.File;

public class Exam01_File {
	public static void main(String[] args) {
		
		// ������ ��ü��(�ν��Ͻ�ȭ) ����� ���
		File file = new File("test.txt"); // ���� �������� ���ڰ� : HDD �ش� ������ ��� �� + ���ϸ� + Ȯ����
		// ���� ������Ʈ �ȿ� �ֱ⶧���� ��ΰ��� �������־ ��
		// ������ Ȯ���ڱ����� �̸��� ���Ѵٰ� �����ؾ���
		
		System.out.println("�� ������ ���� �����ϴ°�? " + file.exists());
		System.out.println("�����ΰ�? " + file.isFile());
		System.out.println("�����ΰ�? " + file.isDirectory());
		System.out.println("������ ũ�� : " + file.length());
		System.out.println("������ ���� ��� : " + file.getAbsolutePath());
		System.out.println("������ �̸� : " + file.getName());
		
		File newFile = new File("new.txt"); // ���� ���� �����
		if(!newFile.exists()) { //if�� ������ �������Ͽ� ��������
			// Checked Exception : �ڵ尡 ���� ����Ǳ⵵ ���� ������ �߻��� �� �ֵ��� �������� ����
			try{
				newFile.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		File newFolder = new File("newFolder");
		if(!newFolder.exists()) {
			newFolder.mkdir();
		}
		
	}

}
