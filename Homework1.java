package HomeworkChapter9;

class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	// five-argument constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		// implicit call to Object's default constructor occurs here
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	} // end constructor

	// return first name
	public String getFirstName() {
		return firstName;
	}

	// return last name
	public String getLastName() {
		return lastName;
	}

	// return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	// return String representation of CommissionEmployee object
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n", "commission employee", firstName, lastName,
				"social security number", socialSecurityNumber);
	}
} // end class CommissionEmployee

class CommissionEmployee extends Employee {
	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage

	// five-argument constructor
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);

		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
	} // end constructor

	// set gross sales amount
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		this.grossSales = grossSales;
	}

	// return gross sales amount
	public double getGrossSales() {
		return grossSales;
	}

	// set commission rate
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

		this.commissionRate = commissionRate;
	}

	// return commission rate
	public double getCommissionRate() {
		return commissionRate;
	}

	// calculate earnings
	public double earnings() {
		return commissionRate * grossSales;
	}

	// return String representation of CommissionEmployee object
	@Override // indicates that this method overrides a superclass method
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "gross sales", grossSales,
				"commission rate", commissionRate);
	}
} // end class CommissionEmployee

class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary; // base salary per week

	// six-argument constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		// explicit call to superclass CommissionEmployee constructor
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

		// if baseSalary is invalid throw exception
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	// set base salary
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	// return base salary
	public double getBaseSalary() {
		return baseSalary;
	}

	// calculate earnings
	@Override
	public double earnings() {
		// not allowed: commissionRate and grossSales private in superclass
		return baseSalary + (getCommissionRate() * getGrossSales());
	}

	// return String representation of BasePlusCommissionEmployee
	@Override
	public String toString() {
		// not allowed: attempts to access private superclass members
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", "base-salaried commission employee",
				getFirstName(), getLastName(), "social security number", getSocialSecurityNumber(), "gross sales",
				getGrossSales(), "commission rate", getCommissionRate(), "base salary", baseSalary);
	}
}

public class Homework1 {

	public static void main(String[] args) {
		// instantiate CommissionEmployee object
		CommissionEmployee employee = new CommissionEmployee("Lena", "Golovach", "222-22-2222", 10000, .06);

		// get commission employee data
		System.out.println("Employee information obtained by get methods:");
		System.out.printf("%n%-15s %s%n", "Last name is :", employee.getLastName());
		System.out.printf("%s %-15s%n", "First name is :", employee.getFirstName());
		System.out.printf("%s %s%n", "Social security number is :", employee.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Gross sales is - ", employee.getGrossSales());
		System.out.printf("%s %.2f%n", "Commission rate is - ", employee.getCommissionRate());

		employee.setGrossSales(5000);
		employee.setCommissionRate(.1);

		System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee);

		System.out.println(
				"______________________________________________________________________________________________________");

		// instantiate BasePlusCommissionEmployee object
		BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Akakii", "Kazantip", "333-33-3333", 5000,
				.04, 300);

		// get base-salaried commission employee data
		System.out.println("Employee information obtained by get methods:");
		System.out.printf("%n%s %s%n", "First name is", employee2.getFirstName());
		System.out.printf("%s %s%n", "Last name is", employee2.getLastName());
		System.out.printf("%s %s%n", "Social security number is", employee2.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Gross sales is", employee2.getGrossSales());
		System.out.printf("%s %.2f%n", "Commission rate is", employee2.getCommissionRate());
		System.out.printf("%s %.2f%n", "Base salary is", employee2.getBaseSalary());

		employee2.setBaseSalary(1000);

		System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee2.toString());
	} // end main
}


//9.14 (Employee Hierarchy) In this chapter, you studied an inheritance hierarchy in which class
//BasePlusCommissionEmployee inherited from class CommissionEmployee. However, not all types of
//employees are CommissionEmployees. In this exercise, you’ll create a more general Employee superclass
//that factors out the attributes and behaviors in class CommissionEmployee that are common to all Employees. 
//The common attributes and behaviors for all Employees are firstName, lastName, socialSecurityNumber, getFirstName, 
//getLastName, getSocialSecurityNumber and a portion of method toString. Create a new superclass Employee that contains 
//these instance variables and methods and a constructor. Next, rewrite class CommissionEmployee from Section 9.4.5 as a 
//subclass of Employee. Class CommissionEmployee should contain only the instance variables and methods that are not declared 
//in superclass Employee. Class CommissionEmployee’s constructor should invoke class Employee’s constructor and CommissionEmployee’s 
//toString method should invoke Employee’s toString method. Once you’ve completed these modifications, run the CommissionEmployeeTest 
//and BasePlusCommissionEmployeeTest apps using these new classes to ensure that the apps still display the same results for
//a CommissionEmployee object and BasePlusCommissionEmployee object, respectively.