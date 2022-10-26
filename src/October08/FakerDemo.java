package October08;

import com.github.javafaker.Faker;

public class FakerDemo {


    public static void main(String[] args) {


        Faker faker = new Faker();

        System.out.println(faker.address().fullAddress());
    }
}

