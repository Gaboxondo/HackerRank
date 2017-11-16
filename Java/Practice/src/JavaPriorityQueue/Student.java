package JavaPriorityQueue;

public class Student {
	
	private Integer id;
	private String name;
	private double cgpa;
	
	public Student(Integer id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}
	
	public Integer getID() {
		return id;
	}
	public void setID(Integer d) {
		this.id = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCGPA() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

}
