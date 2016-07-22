package jp.asojuku.testmanagement.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.lang3.StringUtils;

import jp.asojuku.testmanagement.dto.TestInfoDto;
import jp.asojuku.testmanagement.dto.TestSeachResultDto;
import jp.asojuku.testmanagement.entity.TestListEntity;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;


public class SeachTestKeywordBo 
{
	private static final String  TEST_SEACH_INFO_SQL = "SELECT " + TestListEntity.TEST_ID + ","+ TestListEntity.TEST_DAY + "," + TestListEntity.TEST_SPONSOR + "," + TestListEntity.TEST_NAME +
			 " FROM test_list WHERE " + TestListEntity.TEST_NAME +" like "+ "?";
	private static final int     TEST_SEACH_INFO_SQL_IDX = 1;
	
	
	public TestSeachResultDto seachTestKeyword(String keyword) throws SQLException, SystemErrorExcepton{
		ResultSet rs = null;
		TestSeachResultDto testseachresultdto = new TestSeachResultDto();
		TestListEntity testlistentity;
		String keyword_resut;
		TestInfoDto testinfodto;
		//検定キーワードの中に、スペースが入っていてもいいように。
		keyword_resut = makeLikeParameter(keyword);
		Dbcontrol db = new Dbcontrol();
		int count = 0;
		try{
			db.connect();
			db.prepareStatement(TEST_SEACH_INFO_SQL);
			db.setString(TEST_SEACH_INFO_SQL_IDX,keyword_resut );
		
			rs = db.executeQuery();
			while(rs.next()){
				testlistentity = new TestListEntity();
				testlistentity.setTest_id(rs.getString(TestListEntity.TEST_ID));
				testlistentity.setTest_name(rs.getString(TestListEntity.TEST_NAME));
				testlistentity.setTest_sponsor(rs.getString(TestListEntity.TEST_SPONSOR));
				testlistentity.setTest_day(rs.getDate(TestListEntity.TEST_DAY));
				//検定テーブルを検定DTOに入れる。
				testinfodto = chageEntityToDto(testlistentity);
				//検定リストへ保存
				testseachresultdto.add(testinfodto);
				//件数を保存
				count++;
			}
			//検定件数を入れる。
			testseachresultdto.setSearchNum(count);
			testseachresultdto.setKeyword(keyword);;

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			throw new SystemErrorExcepton();

		} catch (NamingException e) {
			
			e.printStackTrace();
			throw new SystemErrorExcepton();
		} finally {

	        // 接続を閉じる
        	if( rs != null ){
				rs.close();
        	}
        	//psとconを閉じる。
    		db.close();
		}
		return testseachresultdto;
		
		
		
	}
	private String makeLikeParameter(String param){

		//%があった場合を考慮
		StringUtils.replace(param, "%", "\\%");
		//_があった場合を考慮
		StringUtils.replace(param, "_", "\\_");

		return "%"+param+"%";
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
	
	
}
