package JavaPriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Priorities {
	
	public List<Student> getStudents(List<String> events){
		
		StudentComparator comparador = new StudentComparator();
		Queue<Student> theQueue = new PriorityQueue<>(comparador);
		List<Student> finalList = new ArrayList<>();
		
		for(Integer i = 0; i< events.size(); i ++) {
			String[] eventaux = divideEvent(events.get(i));
			String action = eventaux[0];
			if(action.equals("ENTER")) {
				
				String name = eventaux[1];
				Double cgpa = Double.parseDouble(eventaux[2]);
				Integer id = Integer.parseInt(eventaux[3]);
				
				Student studentToQueue = new Student(id,name,cgpa);
				 
				theQueue.add(studentToQueue);

				
				System.out.println(studentToQueue.getName() + " with ID: " +  studentToQueue.getID() + 
						" with CGPA: " + studentToQueue.getCGPA() + " has entered into the queue");
			}
			else if(action.equals("SERVED")) {
				Student studentOut = theQueue.poll();
				System.out.println(studentOut.getName() + " with ID: " +  studentOut.getID() + 
						" with CGPA: " + studentOut.getCGPA() + " has run away");
			}
		}
		
		while(!theQueue.isEmpty())
		{
			finalList.add(theQueue.poll());
		}
		
		return finalList;
		
		
	}
	
	public String[] divideEvent(String event) {
		String[] eventParts = event.split(" ");
		return eventParts;
	}

}
