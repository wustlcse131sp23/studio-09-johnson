package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int idNumber;
	private int attemptedCredits;
	private int passingCredits;
	private double gradeQualityPoints;
	private double bearBucks;
		
		public Student(String first, String last, int id) {
			firstName = first;
			lastName = last;
			idNumber = id;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public String getFullName() {
			return this.getFirstName() + " " + this.getLastName();
		}
		
		public int getId() {
			return idNumber;
		}
		
		public int getTotalAttemptedCredits() {
			return attemptedCredits;
		}
		
		public int getTotalPassingCredits() {
			return passingCredits;
		}
		
		public double getQualPoints() {
			return gradeQualityPoints;
		}
		
		public double calculateGradePointAverage() {
			return this.getQualPoints() / this.getTotalAttemptedCredits();
		}
		
		public void submitGrade(double grade, int credits) {
			attemptedCredits = attemptedCredits + credits;
			if(grade >= 1.7) {
				passingCredits = passingCredits + credits;
			}
			gradeQualityPoints = gradeQualityPoints + (grade * credits);
		}
		
		public String getClassStanding() {
			if(passingCredits < 30) {
				return "First Year";
			}
			if(passingCredits < 60) {
				return "Sophomore";
			}
			if(passingCredits < 90) {
				return "Junior";
			}
			else {
				return "Senior";
			}
		}
		
		public boolean isEligibleForPhiBetaKappa() {
			if(attemptedCredits >= 98 && this.calculateGradePointAverage() >= 3.60) {
				return true;
			}
			if (attemptedCredits >= 75 && this.calculateGradePointAverage() >= 3.80) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void depositBearBucks(double amount) {
			bearBucks = bearBucks + amount;
		}
		
		public void deductBearBucks(double amount) {
			bearBucks = bearBucks - amount;
		}
		
		public double getBearBucksBalance() {
			return bearBucks;
		}
		
		public double cashOutBearBucks() {
			if(this.getBearBucksBalance() <= 10) {
				bearBucks = 0;
				return 0.0;
			}
			else {
				double temp = this.getBearBucksBalance();
				bearBucks = 0;
				return temp - 10;
			}
		}
		
		public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
			Student legacyStudent;
			if(isHyphenated) {
				String lastName = this.getLastName() + "-" + otherParent.getLastName();
				legacyStudent = new Student(firstName, lastName, id);
			}
			else {
				String lastName = this.getLastName();
				legacyStudent = new Student(firstName, lastName, id);
			}
			legacyStudent.depositBearBucks(this.cashOutBearBucks() + otherParent.cashOutBearBucks());
			return legacyStudent;
		}
		
		public String toString() {
			return firstName + " " + lastName + " " + idNumber;
		}
	}
