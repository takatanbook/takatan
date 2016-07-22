package jp.asojuku.testmanagement.bo;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;

import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;

public class ExamationDeleteBo extends HttpServlet{



		//受験検定の削除のSQL
		private static final String EXAMATION_DELETE_BY_UP_SQL =
				"DELETE FROM examation WHERE exa_id = ?";
		private static final int EXAMATION_INFO_BY_UP_ID_IDX = 1;

		public int examationDelete(int id) throws SystemErrorExcepton{
			int result = 0;
			Dbcontrol db = new Dbcontrol();
			try {
				db.connect();
				db.beginTranzaction();
				db.prepareStatement(EXAMATION_DELETE_BY_UP_SQL);
				db.setInt(EXAMATION_INFO_BY_UP_ID_IDX, id);
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
