package com.fileio.quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz04_Notepad {

	public static void makeMemo(String memo, String memoName) {
		try (FileWriter fw = new FileWriter(memoName, true);) {
			fw.write(memo + "\n");
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readFile(String memoName) {
		try (FileReader fr = new FileReader(memoName); BufferedReader br = new BufferedReader(fr);) {
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modifyMemo(String memoName, boolean keep, String modify) {
		if (keep) {
			try (FileWriter fw = new FileWriter(memoName, true);) {
				fw.write(modify + "\n");
				fw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (FileWriter fw = new FileWriter(memoName);) {
				fw.write(modify + "\n");
				fw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<>();

		while (true) {

			System.out.println("\n*** �ܼ� �޸��� ***");
			System.out.println("1. �޸��ϱ�");
			System.out.println("2. �޸��� ����");
			System.out.println("3. �޸� �����ϱ�");
			System.out.println("4. ���α׷� ����");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				System.out.println("�޸� �Է�");
				System.out.print(">> ");
				String memo = sc.nextLine();
				System.out.println("������ ������ �̸��� �Է��ϼ���.");
				System.out.print(">> ");
				String memoName = sc.nextLine();

				list.add(memoName);
				makeMemo(memo, memoName);

			} else if (menu == 2) {
				System.out.println("===== ����� �޸� ��� =====");

				if (list.size() == 0) {
					System.out.println("����� �޸� �����ϴ�.");
				} else {

					for (int i = 0; i < list.size(); i++) {
						System.out.println((i + 1) + ". " + list.get(i));
					}
					System.out.println("��� ������ �̸��� �Է��ϼ���.");
					System.out.print(">> ");
					String memoName = sc.nextLine();

					readFile(memoName);

				}

			} else if (menu == 3) {
				System.out.println("===== ����� �޸� ��� =====");

				for (int i = 0; i < list.size(); i++) {
					System.out.println((i + 1) + ". " + list.get(i));
				}

				System.out.println("������ ������ �̸��� �Է��ϼ���.");
				System.out.print(">> ");
				String memoName = sc.nextLine();

				System.out.println("��������� �����ϼ���.");
				System.out.println("1. �����");
				System.out.println("2. �̾��");
				System.out.print(">> ");
				int no = Integer.parseInt(sc.nextLine());

				System.out.println("������ ������ �Է��ϼ���.");
				System.out.print(">> ");
				String modify = sc.nextLine();

				if (no == 1) {
					modifyMemo(memoName, false, modify);
				} else if (no == 2) {
					modifyMemo(memoName, true, modify);
				}
				System.out.println("�����Ϸ�");

			} else if (menu == 4) {
				System.out.println("���α׷� ����");
				break;
			}

		}
	}
}
