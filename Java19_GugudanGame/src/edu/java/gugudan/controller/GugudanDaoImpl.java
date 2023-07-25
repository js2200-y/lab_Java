package edu.java.gugudan.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.gugudan.model.GugudanModel;
import oracle.jdbc.OracleDriver;

import static edu.java.gugudan.controller.Gugudan.Entity.*;
import static edu.java.gugudan.ojdbc.OracleConnect.*;

public class GugudanDaoImpl implements GugudanDao {

		// 싱글톤
	private static GugudanDaoImpl instance = null;
	private GugudanDaoImpl() { }
	public static GugudanDaoImpl getInstance () {
		if (instance == null) {
			instance = new GugudanDaoImpl();
		}
		return instance;
	}
	
	// 오라클 DB에 접속한 Connection 객체를 리턴.
	private Connection getConnection() throws SQLException {
		// 오라클 JDBC 드라이버(라이브러리)를 등록.
		DriverManager.registerDriver(new OracleDriver());
		// 오라클 DB에 접속
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}
	
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
		
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		closeResources(conn, stmt);
	}
	
	
	// select * from contacts order by cid
	private static final String SQL_SELECT_ALL
				= "select * from " + TBL_NAME +" order by "+ COL_CID;
	@Override
	public List<Gugudan> read() {
		ArrayList<Gugudan> list = new ArrayList<>();
			
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_ALL);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) { // select 결과에서 행(row) 데이터가 있으면
				// 각 컬럼의 값들을 읽음.
				int cid = rs.getInt(COL_CID);
				String okcount = rs.getString(COL_OKCOUNT);
				String failcount = rs.getString(COL_FAILCOUNT);
								
				Gugudan gugudan = new Gugudan(cid, okcount, failcount);
				list.add(gugudan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

		
	// insert into contacts (name, phone, email) values (?, ? ,?);
	private static final String SQL_INSERT = 
			"insert into " + TBL_NAME
			+ " ("+ COL_OKCOUNT + ", " + COL_FAILCOUNT + ") "
			+ " values(?, ?)";
	
	@Override
	public int create(Gugudan gugudan) {
		int result = 0; // insert 결과를 저장하고 리턴할 변수.
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println(SQL_INSERT);
			stmt = conn.prepareStatement(SQL_INSERT);
//			stmt.setInt(1, gugudan.getCid());
			stmt.setString(1, gugudan.getOkcount());
			stmt.setString(2, gugudan.getFailcount());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	// delete from contacts where cid = ?;
	private static final String SQL_DELETE =
			"delete from " + TBL_NAME  + " where " + COL_CID + " = ?";
	@Override
	public int delete(Integer cid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			System.out.println(SQL_DELETE);
			
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cid);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

}
