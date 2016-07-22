package jp.asojuku.testmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class SeachStudentHistoryTestResultDTO {
	private List<SeachStudentHistoryTestDTO> studenttestloginfolist;
	/** 最大ページ数 */
	int maxPage;
	/** 表示オフセット */
	int offset;
	/** 検索結果のリスト *//** 検索した総件数 */
	int searchNum;
	/** 検索結果の表示件数 */
	int areaDispNum;
	/** 表示ページ数 */
	int dispPage;
	
	/** キーワード **/
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<SeachStudentHistoryTestDTO> getstudenttestloginfolist() {
		return studenttestloginfolist;
	}

	public void setstudenttestloginfolist(List<SeachStudentHistoryTestDTO> studenttestloginfolist) {
		this.studenttestloginfolist = studenttestloginfolist;
	}
	public void add(SeachStudentHistoryTestDTO studentdto){
		if(studenttestloginfolist == null){
			studenttestloginfolist = new ArrayList<SeachStudentHistoryTestDTO>();
		}
		studenttestloginfolist.add(studentdto);
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

	public int getAreaDispNum() {
		return areaDispNum;
	}

	public void setAreaDispNum(int areaDispNum) {
		this.areaDispNum = areaDispNum;
	}

	public int getDispPage() {
		return dispPage;
	}

	public void setDispPage(int dispPage) {
		this.dispPage = dispPage;
	}

}
