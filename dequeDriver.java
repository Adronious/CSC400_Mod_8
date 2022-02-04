import java.util.Iterator;
import java.util.Scanner;


public class dequeDriver extends personDeque{

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		personDeque personList = new personDeque();
		
		//Prompt user for 5 People, First, Last, and Age, add to deque
		System.out.println("Enter first name, last name, and age.");
		System.out.println(personList.addPerson(scnr));
		
		System.out.println("Enter first name, last name, and age.");
		System.out.println(personList.addPerson(scnr));
		
		System.out.println("Enter first name, last name, and age.");
		System.out.println(personList.addPerson(scnr));
		
		System.out.println("Enter first name, last name, and age.");
		System.out.println(personList.addPerson(scnr));
		
		System.out.println("Enter first name, last name, and age.");
		System.out.println(personList.addPerson(scnr));

		System.out.println("\nList in order of first added: ");
		
		//Iterate thru deque to show it is populated
		Iterator<Person> iterator = myDeque.iterator();
		
		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.allData);
		}
		
		//Prompt user to select parameter to sort by
		Boolean sorted = false;
		while (!sorted) {
			
			System.out.println("\nTo sort by Age enter 'a' to sort by last name type 'n'. "
								+ "\nTo quit type 'q'. Press enter to confirm.");
			//Collect input from user
			char sortBy = scnr.next().charAt(0);
		
			//Convert user input to lower case to compare to switch
			switch (Character.toLowerCase(sortBy)) {
				case 'a':
					//Sort by age and print deque after sorting
					quickSortAge(myDeque);
					System.out.println("\nDeque sorted by age:");
				
					Iterator<Person> iteratorSorted = myDeque.iterator();
				
					while (iteratorSorted.hasNext()) {
						Person person = iteratorSorted.next();
						System.out.println(person.allData);
					}
				break;
				
				case 'n':
					quickSortName(myDeque);
					System.out.println("\nDeque sorted by last name:");
				
					Iterator<Person> iteratorSorted2 = myDeque.iterator();
				
						while (iteratorSorted2.hasNext()) {
							Person person = iteratorSorted2.next();
							System.out.println(person.allData);
						}		
				break;
				
				//Quit command ends program while loop by making sorted true
				case 'q':
					System.out.println("Sorting complete. Gooddbye.");
					sorted = true;
					break;
					
				default:
					System.out.println("Try again");
					//Keeping sorted false continues loop until valid input is received
					break;
			}
		}
	}
}
