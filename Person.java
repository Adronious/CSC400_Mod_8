
public class Person {

	String firstName;
	String lastName;
	int	age;
	String allData;
	
	public Person() {
		firstName = "John";
		lastName = "Doe";
		age = 0;
	}
	
	//Constructor with attributes and variable to display all
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		allData = firstName +" "+ lastName +" "+ age;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
