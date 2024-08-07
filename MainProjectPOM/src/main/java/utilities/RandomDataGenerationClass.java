package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomDataGenerationClass {
	static Faker faker;
	static long deductionAmt;

	// Method to generate a random client name
	public static String getDeductionAmt() {
		faker = new Faker(new Locale("en-IND"));
		deductionAmt = faker.number().randomNumber();
		return String.valueOf(deductionAmt);
	}

}