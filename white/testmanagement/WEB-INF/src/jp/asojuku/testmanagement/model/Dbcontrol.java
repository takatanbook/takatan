package jp.asojuku.testmanagement.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Dbcontrol {
	
	
	
	private Connection con;
	
	private PreparedStatement ps;
	
	/*データベースに接続するクラス
	 * コネクトするメソッド
	 *
	 */
	
	public void connect() throws NamingException,SQLException{
    	InitialContext ctx;
		try {
			ctx = new InitialContext();
        	DataSource ds =
        		(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

			// MySQLに接続
	        con = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e);
			throw e;	
		} catch (SQLException e) {
			
			System.out.println(e);
			throw e;
		}
	}
	
    //データベースを閉じる
	public void close() throws SQLException{
		if(ps != null){
			ps.close();
		}
		if( con != null ){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				System.out.println("cloze No can do.");
			}
		}
	}
	//トランザクションを実行する
	public void beginTranzaction() throws SQLException{
			if( con != null ){
				con.setAutoCommit(false);
			}
	}
	//トランザクションを確定
	public void commit() throws SQLException{
		if( con != null ){
			try {
				con.commit();
			} finally{
				con.setAutoCommit(true);
			}
		}

	}
	//ロールバックします
	public void rollback() throws SQLException{
		if( con != null ){
			try {
				con.rollback();
			} finally{
				con.setAutoCommit(true);
			}
		}

	}
	public void  prepareStatement(String name) throws SQLException{
		if( con == null ){
			//throw new DbconectErrorException();
			return;
		}
		ps = con.prepareStatement(name);
	}
	
	public  void setString(int index,String name) throws SQLException {
		
		ps.setString(index,name);
	}
	public void setInt(int index,Integer name) throws SQLException{
		ps.setInt(index,name);
	}
	public void setDate(int index,Date name) throws SQLException{
		ps.setDate(index, name);
	}
	public ResultSet executeQuery() throws SQLException {
		return ps.executeQuery();
	}

	public int executeUpdate() throws SQLException {
		
		return ps.executeUpdate();
		
	}
}
