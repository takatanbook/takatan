package jp.asojuku.testmanagement.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import jp.asojuku.testmanagement.dto.TestInfoDto;
import jp.asojuku.testmanagement.dto.TestSeachResultDto;
import jp.asojuku.testmanagement.entity.TestListEntity;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;

public class DeleteTestInfoBo {
	private static final String TEST_INFO_DELETE_SQL ="DELETE FROM test_list "+
			"WHERE "+ TestListEntity.TEST_ID + " = ?";
	private static final String  TEST_SEACH_INFO_SQL = "SELECT " + TestListEntity.TEST_ID + ","+ TestListEntity.TEST_DAY + "," + TestListEntity.TEST_SPONSOR +","+ TestListEntity.TEST_NAME + 
			 " FROM test_list WHERE " + TestListEntity.TEST_ID +" = ? ";
	private static final int  TEST_INFO_DELETE_SQL_IDX = 1;
	private static final int TEST_SEACH_INFO_SQL_IDX = 1;
	
	public int testinfodelete(String testId) throws  SystemErrorExcepton, NamingException, SQLException{
		int result = 0;
		Dbcontrol db = new Dbcontrol();
		try{
			db.connect();
			db.beginTranzaction();
			db.prepareStatement(TEST_INFO_DELETE_SQL);
			db.setString(TEST_INFO_DELETE_SQL_IDX, testId);
			result = db.executeUpdate();
			db.commit();
			
		}catch(NamingException e){
			System.out.println(e.getMessage());
			throw new SystemErrorExcepton();
			
		} catch (SQLException e) {
			SafeRollback(db);
			System.out.println(e.getMessage());
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new SystemErrorExcepton();
		}
		return result;
	}
	public TestSeachResultDto testdeleteinformation(String testId) throws NamingException, SQLException, SystemErrorExcepton{
		TestSeachResultDto result = new TestSeachResultDto();
		ResultSet rs = null;
		TestListEntity testlistentity;
		TestInfoDto testinfodto;
		int count = 0;
		try{
			Dbcontrol db = new Dbcontrol();
			db.connect();
			db.prepareStatement(TEST_SEACH_INFO_SQL);
			db.setString(TEST_SEACH_INFO_SQL_IDX, testId);
			rs = db.executeQuery();
			
			while(rs.next()){
				testlistentity = new TestListEntity();
				testlistentity.setTest_id(rs.getString(TestListEntity.TEST_ID));
				testlistentity.setTest_name(rs.getString(TestListEntity.TEST_NAME));
				testlistentity.setTest_day(rs.getDate(TestListEntity.TEST_DAY));
				testlistentity.setTest_sponsor(rs.getString(TestListEntity.TEST_SPONSOR));
				//検定テーブルを検定DTOに入れる。
				testinfodto = chageEntityToDto(testlistentity);
				result.add(testinfodto);
				count++;
			}
			result.setSearchNum(count);
		}catch(NamingException e){
			System.out.println(e.getMessage());
			throw new SystemErrorExcepton();
		}catch(SQLException e){
			System.out.println(e.getMessage());
			throw new SystemErrorExcepton();
		}
		return result;
	}
	//エンティティをDTOに変換
	private TestInfoDto chageEntityToDto(TestListEntity testlistentity){
			TestInfoDto testinfo = new TestInfoDto();
			testinfo.setTestId(testlistentity.getTest_id());
			testinfo.setTestName(testlistentity.getTest_name());
			testinfo.setSponsor(testlistentity.getTest_sponsor());
			testinfo.setExaminationDate(testlistentity.getTest_day());
			return testinfo;
	}
	private void SafeRollback(Dbcontrol db){

		try {
			db.rollback();
		} catch (SQLException e) {
			//ログの出力のみ
			System.out.println("ロールバックに失敗しました："+e);
		}

	}

}
