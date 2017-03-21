package memberDAO;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.DTO.MemDto;

public class InsertMem {
	
	public void insert(String name, String id, String pw) {
		
		try {
			
			Reader res = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = factory.openSession();
			
			MemDto dto = new MemDto();
			dto.setName(name);
			dto.setId(id);
			dto.setPw(pw);
			
			session.insert("member.insert", dto);
			session.commit();
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
