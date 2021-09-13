package	elfuncs;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class RealDate{
	public static String realDate(Timestamp realDate){
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, ''yyyy");

		return sdf.format(realDate);
	}
}