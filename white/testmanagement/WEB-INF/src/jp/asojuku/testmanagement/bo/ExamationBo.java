package jp.asojuku.testmanagement.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import jp.asojuku.testmanagement.dto.ExamationInfoDto;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;
import jp.asojuku.testmanagement.noobentity.ExamationEntity;

public class ExamationBo {

	private static final String EXAMATION_INFO_BY_UP_SQL =
					"SELECT * FROM examation e, test_list t WHERE e.sdt_id = ? AND e.test_id = t.test_id";
	private static final int EXAMATION_INFO_BY_UP_NAME_IDX = 1;

	ExamationInfoDto examationinfo = new ExamationInfoDto();
	public ExamationInfoDto getExamation(String id) throws SQLException, SystemErrorExcepton{


		ResultSet rs = null;
		ExamationEntity entity = new ExamationEntity();
		Dbcontrol db = new Dbcontrol();
		ExamationInfoDto examation = null;

        try {

        	db.connect();


    		// ステートメント生成


			db.prepareStatement(EXAMATION_INFO_BY_UP_SQL);


	        db.setString(EXAMATION_INFO_BY_UP_NAME_IDX, id);

	        // SQLを実行
	        rs = db.executeQuery();


	        //値を取り出す
	        while(rs.next()){

	        	entity.setTest_name(rs.getString(ExamationEntity.TEST_NAME));
	        	entity.setSponsor(rs.getString(ExamationEntity.SPONSOR));
	        	entity.setTest_day(rs.getString(ExamationEntity.TEST_DAY));
	        	entity.setResult(rs.getInt(ExamationEntity.RESULT));
	        	entity.setExamation_id(rs.getInt(ExamationEntity.EXAMATION_ID));
	        	examation = chegeEntitytoDto(entity);

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
		examationinfo.setResult(entity.getResult());

		return examationinfo;

	}

}
