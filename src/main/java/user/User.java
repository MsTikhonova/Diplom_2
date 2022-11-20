package user;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import config.Config;

public class User {

    private String email;
    private String password;
    private String name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public static User getRandomUser() {
        Faker faker = new Faker();
        return new User(
                faker.internet().emailAddress(),
                Config.PASSWORD,
                RandomStringUtils.randomAlphabetic(10)
        );
    }

    public static User getRandomUserWithoutPassword() {
        Faker faker = new Faker();
        return new User(
                faker.internet().emailAddress(),
                RandomStringUtils.randomAlphabetic(10)
        );
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
