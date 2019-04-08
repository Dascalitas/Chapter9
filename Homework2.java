package HomeworkChapter9;

class HourlyEmployee extends Employee {
	private double hours;
	private double wage;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hours, double wage) {
		super(firstName, lastName, socialSecurityNumber);

		this.hours = hours;
		this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		if (hours < 1 || hours > 168)
			throw new IllegalArgumentException("All human must work not less than 0 and more than 168 hours per week.");

		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if (wage > 0)
			throw new IllegalArgumentException("wage can't be less than 0");

		this.wage = wage;
	}

	// calculate earnings
	public double earnings() {
		if (hours <= 40)
			return hours * wage;
		else
			return hours * (wage * 1.5);
	}

	// return String representation of CommissionEmployee object
	@Override // indicates that this method overrides a superclass method
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", "commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "work hours", hours, "hourly wage",
				wage, "Salary is :", earnings());
	}
}

public class Homework2 {

	public static void main(String[] args) {
		HourlyEmployee empl1 = new HourlyEmployee("Lena", "Golovach", "444-444-444-4444", 30.0, 100);
		HourlyEmployee empl2 = new HourlyEmployee("Akakii", "Kazantip", "555-555-555-5555", 50.0, 100);

		System.out.println(empl1.toString());
		System.out.println(empl2.toString());
	}
}


//9.15 (Creating a New Subclass of Employee) Other types of Employees might include SalariedEmployees who 
//get paid a fixed weekly salary, PieceWorkers who get paid by the number of pieces they produce or HourlyEmployees
//who get paid an hourly wage with time-and-a-half—1.5 times the hourly wage—for hours worked over 40 hours.
//Create class HourlyEmployee that inherits from class Employee (Exercise 9.14) and has instance variable hours (a double) 
//that represents the hours worked, instance variable wage (a double) that represents the wages per hour, a constructor that 
//takes as arguments a first name, a last name, a social security number, an hourly wage and the number of hours worked, set 
//and get methods for manipulating the hours and wage, an earnings method to calculate an HourlyEmployee’s earnings based on 
//the hours worked and a toString method that returns the HourlyEmployee String representation. 
//Method setWage should ensure that wage is nonnegative, and setHours should ensure that the value of hours is between 0 and 168 
//(the total number of hours in a week).
//Use class HourlyEmployee in a test program that’s similar to the one in Fig. 9.5. 