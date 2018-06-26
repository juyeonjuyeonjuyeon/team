package com.team1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.team1.db.DBConn;
import com.team1.vo.UserVO;

public class UserDAO {
	public static void InsertUser(UserVO vo) throws Exception {
		// DB 접속
		Connection db = DBConn.getConnection();
		// 쿼리 날려서 유저 정보를 삽입
		String sql  = "insert into user (name, subject, message) values (?, ?, ?)";
		PreparedStatement pstmt = db.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getSubject());
		pstmt.setString(3, vo.getMessage());
		
		// 쿼리 실행
		pstmt.executeUpdate();
		db.close();
	}
}
