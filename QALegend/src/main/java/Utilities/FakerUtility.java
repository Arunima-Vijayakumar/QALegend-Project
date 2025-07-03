package Utilities;
 import java.util.Random;

//To dynamically construct unique  phone numbers, client names, etc,
//we need to add dependancy (Faker)first, and so we will have the Faker Utility Github provides this 
import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	public static int getRandomNumber() {
		Random rand= new Random(); 
		int randomNumber= rand.nextInt(100000);
		return randomNumber;
	}
	
	
	public static String getFakerFirstName() {
		Faker faker= new Faker(); 
		Address address= faker.address();
		String firstName= address.firstName();
		return firstName;
	}
	public static String getFakerLastName() {
		Faker faker= new Faker(); 
		Address address= faker.address();
		String lastName= address.lastName();
		return lastName;
	}
	public static String getFakerAddress() {
		Faker faker= new Faker(); 
		Address address= faker.address();
		String address1= address.fullAddress();
		return address1;
	}
	
	public static String getFakerCityName() {
		Faker faker= new Faker(); 
		Address address= faker.address();
		String cityName= address.cityName();
		return cityName;
	}
	
	public static String getFakerStateName() {
		Faker faker= new Faker(); 
		Address address= faker.address();
		String stateName= address.state();
		return stateName;
	}
	public static String getFakerCountryName() {
		Faker faker= new Faker(); 
		Address address= faker.address();
		String countryName= address.country();
		return countryName;
	}
	//random class helps with getting company names dynamically, java provides this
	
}
