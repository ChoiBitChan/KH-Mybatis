package member.main;

import java.util.ArrayList;
import java.util.List;

import member.DTO.MemDto;
import memberDAO.SelectMem;

public class TestMain {
	
	public static void main(String[] args) {
		
//		String text = "es";
		SelectMem smem = new SelectMem();
		List<MemDto> list = null;
//		list = smem.search(text);
//		
//		for(MemDto dto : list) {
//			System.out.println("search : " + dto);	// println(�޼ҵ�)�� �����ϸ� toString �޼ҵ带 �����Ѵ�
//		}
		
		List<String> setList = new ArrayList<String>();
		
		String a = "test1";
		String b = "test3";
		
		setList.add(a);
		setList.add(b);
		
		list = smem.whereIn(setList);
		
		for(MemDto dto : list) {
			System.out.println("whereIn : " + dto);
		}
	}
}
