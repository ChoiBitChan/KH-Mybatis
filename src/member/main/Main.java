package member.main;

import java.util.List;
import java.util.Scanner;

import member.DTO.MemDto;
import memberDAO.DeleteMem;
import memberDAO.InsertMem;
import memberDAO.SelectMem;
import memberDAO.UpdateMem;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("selectAll, selectOne, insert �߿� �������ּ���.");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		
		DeleteMem dmem = new DeleteMem();
		UpdateMem umem = new UpdateMem();
		
		if(text.equals("selectAll")) {
			System.out.println("�Է��� �� : " + text);
			SelectMem smem = new SelectMem();
			List<MemDto> list = smem.selectAll();
			
			for(MemDto dto : list) {
				System.out.println("selectAll : " + dto);	// println(�޼ҵ�)�� �����ϸ� toString �޼ҵ带 �����Ѵ�
			}
			return;
		}
		
		if(text.equals("selectOne")) {
			System.out.println("�Է��� �� : " + text);
			System.out.println("ã�� ���̵� �Է��ϼ���.");
			Scanner searchId = new Scanner(System.in);
			String sId = sc.nextLine();
			System.out.println("ã�� ���̵� : " + sId);
			
			SelectMem smem = new SelectMem();
			MemDto selectOneDto = smem.selectOne(sId);
			System.out.println("selectOne : " + selectOneDto);
			return;
		}
		
		if(text.equals("insert")) {
			System.out.println("�Է��� �� : " + text);
			System.out.println("���̵� �������ּ���.");
			Scanner insertId = new Scanner(System.in);
			String id = sc.nextLine();
			System.out.println("�̸��� �������ּ���");
			Scanner insertName = new Scanner(System.in);
			String name = sc.nextLine();
			System.out.println("��й�ȣ�� �������ּ���.");
			Scanner insertPw = new Scanner(System.in);
			String pw = sc.nextLine();
			
			InsertMem imem = new InsertMem();
			imem.insert(id, name, pw);
			
			System.out.println("�Ϸ�Ǿ����ϴ�.");
			
			SelectMem smem = new SelectMem();
			MemDto selectOneDto = smem.selectOne(id);
			System.out.println("selectOne : " + selectOneDto);
			return;
		}
		
		else {
			System.out.println("�Է� �� ����.");
		}
		
		
//		dmem.delete("test2");
		
//		umem.update1("test1", "test222");
//		umem.update2("test1", "test111");
		


		
		
		
		
		
		
		
//		for(int i = 0; i < list.size(); i++) {
//			MemDto dto = list.get(i);
//			System.out.println(dto);
//		}
	}
}
