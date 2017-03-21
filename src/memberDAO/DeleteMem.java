package memberDAO;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeleteMem {
	
	public void delete(String id) {
		
		try {
			
			Reader res = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = factory.openSession();
			
			session.delete("member.delete", id);
			session.commit();
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
