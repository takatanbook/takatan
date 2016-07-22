package jp.asojuku.testmanagement.bo;

import java.sql.SQLException;

import javax.naming.NamingException;

import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;

public class ExamationAddBo {
	private static final String EXAMATION_INSERT_BY_UP_SQL =
			"INSERT INTO examation(sdt_id,test_id,result) VALUES(?,?,?);";
	private static final int EXAMATION_INFO_BY_UP_SDTID_IDX = 1;
	private static final int EXAMATION_INFO_BY_UP_TESTID_IDX = 2;
	private static final int EXAMATION_INFO_BY_UP_RESULT_IDX = 3;


	public int examationInsert(String sdt_id, int test_id, int gouhi) throws SystemErrorExcepton{
		int result = 0;
		Dbcontrol db = new Dbcontrol();
		try {
			db.connect();
			db.beginTranzaction();
			db.prepareStatement(EXAMATION_INSERT_BY_UP_SQL);
			db.setString(EXAMATION_INFO_BY_UP_SDTID_IDX, sdt_id);
			db.setInt(EXAMATION_INFO_BY_UP_TESTID_IDX, test_id);
			db.setInt(EXAMATION_INFO_BY_UP_RESULT_IDX, gouhi);
			result = db.executeUpdate();
			db.commit();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new SystemErrorExcepton();
		} catch(SQLException e){
			SafeRollback(db);
			throw new SystemErrorExcepton();
		}
		return result;
	}

	//ロールバックする
	private void SafeRollback(Dbcontrol db){


		try {
			db.rollback();
		} catch (SQLException e) {
			//ログの出力のみ
			System.out.println("ロールバックに失敗しました："+e);
		}

	}
}
