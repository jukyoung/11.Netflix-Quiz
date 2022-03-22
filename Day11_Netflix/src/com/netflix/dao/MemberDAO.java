package com.netflix.dao;

import java.util.ArrayList;

import com.netflix.dto.Membership;

public class MemberDAO {

	private ArrayList<Membership> list = new ArrayList<>(); //basic standard premium �� ǰ�� �θ�Ŭ���� Membership �ڷ�������
	
	public void insert(Membership dto) { //��.�ν��Ͻ��� �Ѱܼ� list��� ������ �����Ҽ� �ֵ��� �޼��� ����
		list.add(dto);   // ��1.������ ���Ĵٵ� �����̾� �� �޾��� �� �ִ� ������̶�� Ŭ���� -> �������̶�� ������ ���� �Ű������� ����� ������
		//��2.�Ѱܹ��� dto�� �߰����ֱ�
	}
	public ArrayList<Membership> selectAll(){ // ��. ������� �ּҰ��� �����ִ� �޼��带 �������� (list ��ü�� ���Ѱ��� �����̺� ������ �迭�� �ּҰ��� ����)
		return list; //��. list�� �ڷ����� ��ȯ �ڷ������� ArrayList<Membership>
		//��.�Ű������� ���� �ʿ���� ��ȯ���ٰ� list�� ��ȯ
	}
	public Membership selectById (String id) { //��. �Ѱܹ��� �Ű����� �Է� String id , nickname
		// ����� ������ ��ȯ ���ְڴ�.
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) { // ����ڰ� �Է��� ���̵�� ���� ��ġ�ϴ� ���̵� �ִ��� �˻�
				return list.get(i); // �ν��Ͻ� ��ü�� ��ȯ 	
			} //else { return null;} ���� ���� ���� -> ��ġ���� ���� ȸ���� ������ ��ġ�ϴ� ȸ������ ���� ������ for���� �� �����ʰ� null ���� �����⶧��
		}
		return null; // if���� ������� �ʾ�����쿡 ��ȯ�ؾ��� �� �ʿ�
	}
	public Membership selectByNickname(String nickname) {
		for(Membership dto : list) {
			if(dto.getNickname().equals(nickname)) {
				return dto;
			}
		}
		return null;
	}
	public int modify(String id, String nickname, int point) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id) ) { // ������ ȸ���� ���� -> list.get(i)
				list.get(i).setNickname(nickname); // ���� �����°� �ƴ϶� �������ִ� setter ����
				list.get(i).setPoint(point);
				return 1;
			}
		}
		return -1;
	}
	public  int delete(String id) { // ��ȯ���ִ� ���� 1 ,-1 �̹Ƿ� int ��ȯ�Ű�����
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				return 1;
			}
		}
		return -1;
	}	
	public boolean doesIdExist(String id){
		for(Membership dto : list) {
			if(dto.getId().equals(id)){
				return true; // id �����Ѵ�
			}
		}
		return false;
	}
	public boolean doesNickExist(String nickname) {
		for(Membership dto : list) {
			if(dto.getNickname().equals(nickname)) {
				return true;
			}
		}
		return false;
	}
	}

