package jp.asojuku.testmanagement.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static java.sql.Date toDate(String day) throws ParseException{
	//public void toDate(String day) throws ParseException{
		//string containing date
		String strDate = day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date date = sdf.parse(strDate);
	    java.sql.Date sqlDate = new Date(date.getTime());
	    return sqlDate;
	}

}
