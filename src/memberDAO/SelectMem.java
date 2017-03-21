package memberDAO;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.DTO.MemDto;

public class SelectMem {
	
	public List<MemDto> selectAll() {
		
		List<MemDto> list = null;
		
		try {
			Reader res = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = factory.openSession();
			
			list = session.selectList("member.selectAll");
			
			session.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public MemDto selectOne(String id) {
		
		MemDto dto = null;
		
		try {
			Reader res = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = factory.openSession();
			
			dto = new MemDto();
			
			dto = session.selectOne("member.selectOne", id);
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<MemDto> search(String id) {
		
		List<MemDto> list = null;
		
		try {
			Reader res = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = factory.openSession();
			
			list = session.selectList("member.search", id);
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<MemDto> whereIn(List<String> list) {
		List<MemDto> getList = null;
		
		try {
			Reader res = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = factory.openSession();
			
			getList = session.selectList("member.whereIn", list);
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return getList;
	}
}
