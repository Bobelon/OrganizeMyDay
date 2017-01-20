import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculations {
	
	public static String getDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
}
