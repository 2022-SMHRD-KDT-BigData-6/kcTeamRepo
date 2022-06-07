package com.database;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	// Connection Pool
	// SqlSessionFactory : SQL 연결을 만들어내고, 가지고있는 객체
	private static SqlSessionFactory sqlSessionFactory;

	// 초기화 블럭 : 프로그램 시작시 static 변수들이 할당되자마자 실행
	static {
		try {
			// resource -> config.xml 파일의 경로
			String resource = "com/database/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 다른 DAO 파일에서 sqlSessionFactory를 꺼낼 수 있도록하는
	// Getter
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
