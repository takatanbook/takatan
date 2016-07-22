package jp.asojuku.testmanagement.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.dto.ExamationInfoDto;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;
import jp.asojuku.testmanagement.noobentity.ExamationEntity;

public class ExamationAddSearchBo {

	private static final String EXAMATION_SEARCH_SQL =
			"SELECT * FROM test_list WHERE date_format(test_day,'%Y/%m') = ?";
	private static final int EXAMATION_INFO_BY_UP_YEAR_IDX = 1;
	//private static final int EXAMATION_INFO_BY_UP_MONTH_IDX = 2;



	ExamationInfoDto examationinfo = new ExamationInfoDto();

	public ExamationInfoDto examationsearch(String testday, HttpServletRequest request) throws SQLException, SystemErrorExcepton{

		ExamationEntity entity = new ExamationEntity();
		Dbcontrol db = new Dbcontrol();
		ResultSet rs = null;
		ExamationInfoDto examation = null;
		int flg;

		HttpSession examationsession = request.getSession(false);
		ExamationInfoDto examationinfo2 = (ExamationInfoDto)examationsession.getAttribute("examationinfo");


		try{
			db.connect();

			db.prepareStatement(EXAMATION_SEARCH_SQL);


	        db.setString(EXAMATION_INFO_BY_UP_YEAR_IDX, testday);

	        rs = db.executeQuery();
	        while(rs.next()){
	        	entity.setTest_name(rs.getString(ExamationEntity.TEST_LIST_NAME));
	        	entity.setSponsor(rs.getString(ExamationEntity.TEST_SPONSOR));
	        	entity.setTest_day(rs.getString(ExamationEntity.TEST_LIST_DAY));
	        	entity.setExamation_id(rs.getInt(ExamationEntity.TEST_ID));
	        	flg = 0;
	        	for(int i = 0;i < examationinfo2.getTestName().size();i++){
	        		if(examationinfo2.getTestName().get(i) == entity.getTest_name() && examationinfo2.getResult().get(i) != 1){
	        			flg = 1;
	        		}
	        	}
	        	if(flg == 0){
	        		examation = chegeEntitytoDto(entity);
	        	}

	        }


		} catch (SQLException e) {
			//例外発生時はログを出力し、上位へそのままスロー
			throw new SystemErrorExcepton();

		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new SystemErrorExcepton();
		} finally {

	        // 接続を閉じる
        	if( rs != null ){
				rs.close();
        	}


    		db.close();
		}

		return examation;

	}
	public ExamationInfoDto chegeEntitytoDto(ExamationEntity entity){

		examationinfo.setExamationId(entity.getExamation_id());
		examationinfo.setTestName(entity.getTest_name());
		examationinfo.setSponsor(entity.getSponsor());
		examationinfo.setTestDay(entity.getTest_day());

		return examationinfo;

	}
}
