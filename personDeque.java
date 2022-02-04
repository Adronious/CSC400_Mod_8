import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class personDeque {
	//Create Deque to populate with Person objects
	static Deque<Person> myDeque = new LinkedList<>();
	static Person[] aList;
	
	//Method to add Person details by collecting from scanner
	public String addPerson(Scanner scnr) {
		Person currentPerson;
		String firstName = scnr.next();
		String lastName = scnr.next();
		int age = scnr.nextInt();
		
		//Adds Person to Deque using constructor
		currentPerson = new Person(firstName, lastName, age);
		myDeque.add(currentPerson);
	//Confirmation message when Person is added	
	return firstName +" "+ lastName +" "+ "Added";
	}
	
	//Method to sort by Age, first converts to Array and passes to quickSort
	public static void quickSortAge(Deque<Person> list) {
		//Converts to Array
		aList = list.toArray(new Person[list.size()]);
		int first = 0;
		int last = myDeque.size() - 1;
		
		/*
		//TEST: to see if Array contains THINGS
		System.out.println("\nTEST: deque has " + myDeque.size() + " Entries.\nMy array has People too");
		for (Person arrayList : aList) {
			System.out.print(arrayList.getAge() +" ");
		}
		System.out.println();*/

		//Passes Array to quickSortAge
		quickSortAge(aList, first, last);	
	}
	
	//Recursive call to quickSortAge
	private static void quickSortAge(Person[] list, int first, int last) {
		//Base Case to end recursion when index of first and last are equal
		if (first < last) {
			
		//partition returns pivotIndex, defines first and last
		int pivotIndex = partitionAge(list, first, last);
		
		//Sorts smaller side
		quickSortAge(list,first, pivotIndex - 1);
		
		//Sorts larger size
		quickSortAge(list, pivotIndex + 1, last);
		}
		//Clears and re-populates myDeque with sorted list
		myDeque.clear();
		for (Person sortedPpl : aList) {
			myDeque.add(sortedPpl);
		}
		
	}
	
	//Create Partition for quick sort
	private static int partitionAge(Person[] list, int first, int last) {
		//Find mid point by dividing size of current array by 2
		int mid = (first + last)/2;
		//Swap pivotValue to end of list to get it out of the way
		Person pivotValue = list[mid];
		list[mid] = list[last];
		list[last] = pivotValue;
		int pivotIndex = last;
		
		//Establish index to increment while looking for out of order elements
		int indexFromLeft = first;
		int indexFromRight = last - 1;
		boolean done = false;
		//While loop to continue until done
		while (!done) {
			//Compare age of Person on left to pivotValue age looking for larger element
			while (list[indexFromLeft].getAge() < pivotValue.getAge()) {
				indexFromLeft++;
			}
			//Compare age of Person on right to pivotValue age looking for smaller element
			//IMPORTANT: indexOfRight must be > 0 or else triggers out of bounds exception
			while ((list[indexFromRight].getAge() > pivotValue.getAge()) && indexFromRight > 0) {
				indexFromRight--;
			}
			//If the index on left is less than index on right, 
			//then the array has more elements to be sorted and should swap the current Persons.
			if (indexFromLeft < indexFromRight) {
				Person tempPerson = list[indexFromRight];
				list[indexFromRight] = list[indexFromLeft];
				list[indexFromLeft] = tempPerson;
				indexFromLeft++;
				indexFromRight--;
			}
			//If index from left is larger that index from right, 
			//there are no more remaining elements to sort, sort is done.
			else {
				done = true;
			}
		}
		//Swap pivot element back to middle location
		Person tempPerson = list[pivotIndex];
		list[pivotIndex] = list[indexFromLeft];
		list[indexFromLeft] = tempPerson;
		pivotIndex = indexFromLeft;
		
		return pivotIndex;
	}
	
	//Method to sort by last name, first converts to Array and passes to quickSort
		public static void quickSortName(Deque<Person> list) {
			//Converts to Array
			aList = list.toArray(new Person[list.size()]);
			int first = 0;
			int last = myDeque.size() - 1;
			
			//Passes Array to quickSortAge
			quickSortName(aList, first, last);	
		}
		
		//Recursive call to quickSortName
		private static void quickSortName(Person[] list, int first, int last) {
			//Base Case to end recursion when index of first and last are equal
			if (first < last) {
				
			//partition returns pivotIndex, defines first and last
			int pivotIndex = partitionName(list, first, last);
			
			//Sorts smaller side
			quickSortName(list,first, pivotIndex - 1);
			
			//Sorts larger size
			quickSortName(list, pivotIndex + 1, last);
			}
			//Clears and re-populates myDeque with sorted list
			myDeque.clear();
			for (Person sortedPpl : aList) {
				myDeque.add(sortedPpl);
			}		
		}	
		
		//Create Partition for quick sort
		private static int partitionName(Person[] list, int first, int last) {
			//Find mid point by dividing size of current array by 2
			int mid = (first + last)/2;
			//Swap pivotValue to end of list to get it out of the way
			Person pivotValue = list[mid];
			list[mid] = list[last];
			list[last] = pivotValue;
			int pivotIndex = last;
			
			//Establish index to increment while looking for out of order elements
			int indexFromLeft = first;
			int indexFromRight = last - 1;
			boolean done = false;
			//While loop to continue until done
			while (!done) {
				//Compare last name of Person on left to pivotValue last name looking for larger value
				while (list[indexFromLeft].getLastName().compareTo(pivotValue.getLastName()) < 0) {
					indexFromLeft++;
				}
				//Compare last name of Person on right to pivotValue last name looking for smaller value
				//IMPORTANT: indexOfRight must be > 0 or else triggers out of bounds exception
				while ((list[indexFromRight].getLastName().compareTo(pivotValue.getLastName()) > 0) && indexFromRight > 0) {
					indexFromRight--;
				}
				//If the index on left is less than index on right, 
				//then the array has more elements to be sorted and should swap the current Persons.
				if (indexFromLeft < indexFromRight) {
					Person tempPerson = list[indexFromRight];
					list[indexFromRight] = list[indexFromLeft];
					list[indexFromLeft] = tempPerson;
					indexFromLeft++;
					indexFromRight--;
				}
				//If index from left is larger that index from right, 
				//there are no more remaining elements to sort, sort is done.
				else {
					done = true;
				}
			}
			//Swap pivot element back to middle location
			Person tempPerson = list[pivotIndex];
			list[pivotIndex] = list[indexFromLeft];
			list[indexFromLeft] = tempPerson;
			pivotIndex = indexFromLeft;
			
			return pivotIndex;
		}

}
