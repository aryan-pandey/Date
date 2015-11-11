package Date;
enum Object {day , month , year}
public class DateOprations extends Date {
	int [] monthw = {0 ,31,28,31,30,31,30,31,31,30,31,30,31};
	int [] dayw = {1,2,3,4,5,6,7};
	String [] dayn = {"Sunday" , "Monday" ,"Tuesday" , "Wednesday" , "Thursday"  , "Friday" , "Saturday"};

	public DateOprations(int day, int month, int year) {
		super(day, month, year);
		
		
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}

	public boolean findLeap (){
		boolean value = false;
		if ((this.getYear()%4 == 0 && this.getYear() % 100 != 0) || (this.getYear() % 400 == 0)){
			value = true;
		}
		if (this.getYear()%4 != 0){
			value = false;
		}
		return value;
	}
	public boolean vaildDate(Object input){
		boolean value =false;
		if (input == Object.year ){
			if (this.year > 0){
				value = true;
			}
		}
		if (input == Object.month ){  
			if (this.month <= 12 && this.month > 0 ){
				value = true;
			}
		}
		if (input == Object.day ){
			this.takeLeap();
			if (this.day > 0 && this.day <= monthw [this.month]){
				value = true;
			}
		}
		
		return value;
	}
	public boolean equalDate (Date input){
		boolean value  = false;
		
		if (this.day == input.day && this.month == input.month && this.year == input.year){
			value = true;
		}
		return value;
	}
	
	public boolean notEqualDate (Date input){
		boolean value  = true;
		
		if (this.day == input.day && this.month == input.month && this.year == input.year){
			value = false;
		}
		return value;
	}
	
	
	public boolean lessThanDate (Date input){
		boolean value  = false;
		
		if (this.day < input.day || this.month < input.month || this.year < input.year){
			value = true;
		}
		return value;
	}
	
	public boolean moreThanDate (Date input){
		boolean value  = false;
		
		if (this.day > input.day || this.month > input.month || this.year > input.year){
			value = true;
		}
		return value;
	}
	

	
	
	public void takeLeap (){
// This is program (method) of some small coding which is necessary for the method ABOVELIMIT();
		// this is a program in which 1 day is added when there is a leap year.........
		if (this.findLeap()){
			monthw [2] = 29;
		}
		if (this.findLeap() == false){
			monthw [2] = 28;
		}
	
		
	}
	

	
	
	public void aboveLimit (Object object){
		
		
		if (object == Object.month){
			if (month > 12){
				year += month / 12;
				month = month%12;
			}
		}

		if (object == Object.day){
			
			this.takeLeap();
			while (day > monthw[month]){
			  this.takeLeap();
				day -= monthw[month];
				month++;
				
				if (month > 12){ 
					month = 1 ;
					year+= 1;
				   }
				
				}
		}
	}
				
	public void setDay(int day){
		Object input = Object.day;
		this.day = day;
		this.aboveLimit(input);
		
	}
	
	public void setMonth(int month){
		Object input = Object.month;
		this.month = month;
		this.aboveLimit(input);
	}
	public void setYear(int year)
	{
		this.year = year;
		if (year <= 0){
			this.year = 1;
		}
	}
	
	public long getRank (){
		long rank = 0;
		DateOprations data = new DateOprations(1, 1, 1);
		while (this.notEqualDate(data)){
			data.addDay(1);
			rank++;
		}
		return rank;
			
	}
	public void addDay(int day){
    day += this.day;
    this.takeLeap();
    this.setDay(day);
	}
	
	public String toString (){
		return getDay()+"/"+getMonth()+"/"+getYear();
	}
	
	
	public void subDay(int input){
	   
		while (input > 0){
			this.takeLeap();
	    	if (input < this.day){
				day -= input;
				input = 0;
			}
			if (input == this.day){
				day -= input;
				input = 0;
				month--;
				if (this.month < 1 ){
					year--;
					month = 12;
				}
				this.day = monthw [this.month];
			}
			
			
			if (input > this.day){
			if (this.day != monthw [this.month])
			{
				input -= this.day; 
				this.day -= this.day;
				month --;
				if (this.month < 1 ) {
					year--;
					month = 12;
				}
				day = monthw [this.month];
				continue;
			}
			if (this.day == monthw [this.month]){
			input -=  monthw [this.month];
			day -= monthw [this.month];
			month --;
			if (this.month < 1 ) {
				year -= 1;
				month = 12;
			}
			day = monthw [this.month];
			}
	
		}

		}
		
	
	
  }
	
	
	

}
