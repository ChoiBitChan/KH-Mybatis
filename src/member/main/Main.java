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
		
		System.out.println("selectAll, selectOne, insert 중에 선택해주세요.");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		
		DeleteMem dmem = new DeleteMem();
		UpdateMem umem = new UpdateMem();
		
		if(text.equals("selectAll")) {
			System.out.println("입력한 값 : " + text);
			SelectMem smem = new SelectMem();
			List<MemDto> list = smem.selectAll();
			
			for(MemDto dto : list) {
				System.out.println("selectAll : " + dto);	// println(메소드)를 실행하면 toString 메소드를 실행한다
			}
			return;
		}
		
		if(text.equals("selectOne")) {
			System.out.println("입력한 값 : " + text);
			System.out.println("찾을 아이디를 입력하세요.");
			Scanner searchId = new Scanner(System.in);
			String sId = sc.nextLine();
			System.out.println("찾을 아이디 : " + sId);
			
			SelectMem smem = new SelectMem();
			MemDto selectOneDto = smem.selectOne(sId);
			System.out.println("selectOne : " + selectOneDto);
			return;
		}
		
		if(text.equals("insert")) {
			System.out.println("입력한 값 : " + text);
			System.out.println("아이디를 설정해주세요.");
			Scanner insertId = new Scanner(System.in);
			String id = sc.nextLine();
			System.out.println("이름을 설정해주세요");
			Scanner insertName = new Scanner(System.in);
			String name = sc.nextLine();
			System.out.println("비밀번호를 설정해주세요.");
			Scanner insertPw = new Scanner(System.in);
			String pw = sc.nextLine();
			
			InsertMem imem = new InsertMem();
			imem.insert(id, name, pw);
			
			System.out.println("완료되었습니다.");
			
			SelectMem smem = new SelectMem();
			MemDto selectOneDto = smem.selectOne(id);
			System.out.println("selectOne : " + selectOneDto);
			return;
		}
		
		else {
			System.out.println("입력 값 오류.");
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
