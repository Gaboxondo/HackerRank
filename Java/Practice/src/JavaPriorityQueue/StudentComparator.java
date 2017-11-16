package JavaPriorityQueue;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	public int compare(Student a, Student b) {
		
		Integer result = null;
		
		if(a.getCGPA() > b.getCGPA()) {
			result = -1;
		}
		else if(a.getCGPA() < b.getCGPA()) {
			result =  1;
		}
		else {
			if(a.getName().compareTo(b.getName()) > 0) {
				result = 1;
			}
			else if(a.getName().compareTo(b.getName()) < 0) {
				result = -1;
			}
			else {
				if(a.getID() > b.getID()) {
					result = -1;
				}
				else if(a.getID() < b.getID()) {
					result = 1;
				}
				else {
					result = 0;
				}
			}
		}
		return result;
	}	
}
