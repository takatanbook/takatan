package jp.asojuku.testmanagement.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestSeachResultDto implements Serializable
{
	private List<TestInfoDto> testlist;
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
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<TestInfoDto> getTestlist() 
	{
		return testlist;
	}

	public void setTestlist(List<TestInfoDto> testlist)
	{
		this.testlist = testlist;
	}
	public void add(TestInfoDto testlist)
	{
		if (this.testlist == null)
		{
			this.testlist = new ArrayList<TestInfoDto>();
		}
		this.testlist.add(testlist);
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
