package CovarianReturn;

public class Flower {
	public String whatsYourName() {
		return "I have many names and types";
	}
}

class Jasmine extends Flower{
	public String whatsYourName() {
		return "Jasmine";
	}
}

class Lily extends Flower{
	public String whatsYourName() {
		return "Lily";
	}
}

class Lotus extends Flower{
	public String whatsYourName() {
		return "Lotus";
	}
}

class State{
	public Flower yourNationalFlower() {
		return new Flower();
	}
}

class WestBengal extends State{
	public Flower yourNationalFlower() {
		return new Jasmine();
	}
}

class Karnataka extends State{
	public Flower yourNationalFlower() {
		return new Lotus();
	}
}

class AndhraPradesh extends State{
	public Flower yourNationalFlower() {
		return new Lily();
	}
}