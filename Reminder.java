package Date;

public class Reminder {
	
	String reminder;
	DateOprations date;
	
	public Reminder (String reminder , DateOprations date) {
		this.reminder = reminder;
		this.date = date;
	}

	public String getReminder() {
		return reminder;
	}

	public DateOprations getDate() {
		return date;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public void setDate(DateOprations date) {
		this.date = date;
	}
	public String showReminder() {
		return getDate().toString()+" ; "+getReminder();
	}
	
	public void addMoreReminder (String reminder){
		this.reminder += " ; " + reminder;
	}

	public void addSubReminder (String reminder){
		this.reminder += " ; (" + reminder +")";
	}
	
}
