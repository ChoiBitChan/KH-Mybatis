package memberDAO;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.DTO.MemDto;

public class UpdateMem {
	
	public void update1(String id, String pw) {
		
		try {
			
			Reader res = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = factory.openSession();
			
			MemDto dto = new MemDto();
			dto.setId(id);
			dto.setPw(pw);
			
			session.update("member.updatePw1", dto);
			session.commit();
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void update2(String id, String pw) {
	
		try {
			
			Reader res = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = factory.openSession();
			
			Map<String, String> map = new HashMap<>();
			map.put("id", id);
			map.put("pw", pw);
			
			session.update("member.updatePw2", map);
			session.commit();
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
