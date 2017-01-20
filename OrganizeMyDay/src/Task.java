import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
	private String name;
	private String description;
	private Date startDate;
	private int time;
	private Date toastDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Date getToastDate() {
		return toastDate;
	}
	public void setToastDate(Date toastDate) {
		this.toastDate = toastDate;
	}
}
