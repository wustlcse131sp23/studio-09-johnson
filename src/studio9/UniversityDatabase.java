package studio9;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	private final Map<String, Student> database;
	
	public UniversityDatabase() {
		database = new HashMap<>();
	}

	public void addStudent(String accountName, Student student) {
		this.database.put(accountName, student);
	}

	public int getStudentCount() {
		return this.database.size();
	}

	public String lookupFullName(String accountName) {
		Student search = this.database.get(accountName);
		if(search == null) {
			return null;
		}
		else {
			return search.getFullName();
		}
	}

	public double getTotalBearBucks() {
		double total = 0;
		for(String i : this.database.keySet()) {
			total += this.database.get(i).getBearBucksBalance();
		}
		return total;
	}
}
