package com.netflix.run;

import com.netflix.dto.Basic;
import com.netflix.dto.Membership;
import com.netflix.dto.Premium;
import com.netflix.dto.Standard;

public class ExamRun01 {
	public static void main(String[] args) {
		
		Membership[] list = new Membership[5];
		list[0] = new Basic("abc123", "ABC���ݸ�","220321", 5000);
		list[1] = new Standard("eee555", "EE", "220320", 3000);
		list[2] = new Premium("www333", "WWW", "220220", 2000);
		
		System.out.println("ID\t���\t�г���\t������\t����Ʈ");
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				System.out.println(list[i].toString());
			}
		}
		
	}

}
