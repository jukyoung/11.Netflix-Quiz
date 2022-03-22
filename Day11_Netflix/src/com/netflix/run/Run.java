package com.netflix.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.netflix.dao.MemberDAO;
import com.netflix.dto.Basic;
import com.netflix.dto.Membership;
import com.netflix.dto.Premium;
import com.netflix.dto.Standard;

public class Run {

	static Scanner sc = new Scanner(System.in); //main �ȿ��� �����ϸ� static �޼��� �������� static ���� �������ֱ�
	
	public static void printList(ArrayList<Membership> list) {
		System.out.println("ID\t���\t�г���\t������\t����Ʈ");
		for (Membership dto : list) {
			System.out.println(dto.toString());
		}
	}
	// try ~ catch���� ��¹����� �ְ� ����ڿ��� �Է��� �ޱ� ������ ����Ŭ�������� �޼��� �����ϱ�
	public static int getNumberInput() {
		while(true) {
			try {
				System.out.print(">> ");
				int menu = Integer.parseInt(sc.nextLine());
				return menu;
			}catch(Exception e){
				System.out.println("���ڰ� �ƴ� ���� �Է��� �� �����ϴ�.");
				e.printStackTrace(); // <- � ������ �߻��ߴ��� �����ִ� �޼��� �ʼ�����
			}
		}
	}
		public static void printMembership(Membership dto) {
			System.out.println("ID\t���\t�г���\t������\t����Ʈ");
			System.out.println(dto.toString());
		}
	
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO(); // DAO �� �ν��Ͻ� �ȿ� ArrayList list(�迭)�� ���ܳ�
		
		String id = null;
		String nickname = null;
		int menu = 0;

		while (true) {

			System.out.println("\n*** Netflix ȸ�� ���� �ý��� ***");
			System.out.println("1. �ű� ȸ�� ���");
			System.out.println("2. ȸ�� ��� ���");
			System.out.println("3. ȸ�� ���� �˻�");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ���� ����");
			System.out.println("6. �ý��� ����");
			menu = getNumberInput();
			
			if (menu == 1) {
				System.out.println("\nȸ�� ��� ����");
				System.out.println("1. Basic");
				System.out.println("2. Standard");
				System.out.println("3. Premium");
				System.out.print(">> ");
				int grade = getNumberInput();

				while (true) {
					System.out.print("\n�ű� ȸ�� ID(7�� �̳�) : ");
					 id = sc.nextLine();
					// �ߺ��˻�
					if (dao.doesIdExist(id)) {
						System.out.println("�ߺ��� ID �Դϴ�.");
						continue;
					} else {
						break;
					}
				}
				while(true) {
					System.out.print("�ű� ȸ�� �г���(4�� �̳�) : ");
					nickname = sc.nextLine();
					if(!dao.doesNickExist(nickname)) {
						break;
					}
					System.out.println("�ߺ��� �г��� �Դϴ�.");
				}
				System.out.print("�ű� ȸ�� ������(210505 ��������) : ");
				String signup_date = sc.nextLine();
				System.out.print("�ű� ȸ�� ����Ʈ : ");
				int point = getNumberInput();

				if (grade == 1) {
					dao.insert(new Basic(id, nickname, signup_date, point)); // �������� �ν��Ͻ�
				} else if (grade == 2) {
					dao.insert(new Standard(id, nickname, signup_date, point)); // ���Ĵٵ��� �ν��Ͻ�
				} else if (grade == 3) {
					dao.insert(new Premium(id, nickname, signup_date, point)); // ��.�����̾��� �ν��Ͻ� -> dao���� �Ѱܼ� list��� ����ҿ� �����ؾ���
																				
				}

			} else if (menu == 2) {
				ArrayList<Membership> list = dao.selectAll();
				printList(list);
//				System.out.println("ID\t���\t�г���\t������\t����Ʈ");
//				// ��. ���� ����Ϸ��� �ϴ� ������ DAO Ŭ���� list ��� ����Ҿȿ� �� �ִ� ����
//				ArrayList<Membership> list = dao.selectAll(); // ��. ��ȯ���ְ� �ִ� ������ ArrayList<Membership> list �� ���
//				// dao.selectAll()�� DAOŬ������ list�� �ּҰ��� �������
//				for (Membership dto : list) {
//					System.out.println(dto.toString());
//				}

			} else if (menu == 3) {
				System.out.println("\n1. ID�� �˻�");
				System.out.println("2. �г������� �˻�");
				System.out.print(">> ");
				int search = getNumberInput();
				if (search == 1) {
					System.out.print("\n�˻� �� ID �Է� : ");
					String Id = sc.nextLine(); // ��. �Է������� �迭�� list�� �����ϴ� ��Ȳ dao�� id / nickname �Ѱ������
					Membership dto = dao.selectById(Id);
					if (dto != null) {
						printMembership(dto);
					} else {
						System.out.println("��ġ�ϴ� ȸ���� ������ �����ϴ�.");
					}

				} else if (search == 2) {
					System.out.print("\n�˻� �� �г��� �Է� : ");
					nickname = sc.nextLine();
					Membership dto = dao.selectByNickname(nickname);
					if (dto != null) {
						printMembership(dto);
					} else {
						System.out.println("��ġ�ϴ� ȸ���� ������ �����ϴ�.");
					}

				} else if (menu == 4) {
					ArrayList<Membership> list = dao.selectAll();
					printList(list);
					
					System.out.print("\n������ ȸ���� ID �Է� : ");
					id = sc.nextLine();
					System.out.print("������ �г��� : ");
					nickname = sc.nextLine();
					System.out.print("������ ����Ʈ : ");
					int point = getNumberInput();
					// ����������� �Ѱ��� �� ���� -> �߻�ȭ ���� ������ new ����

					int rs = dao.modify(id, nickname, point); // �Ѱ�����ϴ°� �ֱ�
					if (rs == 1) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					} else if (rs == -1) {
						System.out.println("������ �� ���� ID �Դϴ�.");
					}

				} else if (menu == 5) {
					ArrayList<Membership> list = dao.selectAll();
					printList(list);
					
					System.out.print("\n������ ȸ���� ID �Է� : ");
					id = sc.nextLine();
					int rs = dao.delete(id);
					if (rs == 1) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					} else if (rs == -1) {
						System.out.println("������ �� ���� ID �Դϴ�.");
					}

				} else if (menu == 6) {
					System.out.println("�ý����� �����մϴ�.");
					break;
				}
			}
		}
	}
}
