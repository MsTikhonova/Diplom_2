import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import user.Token;
import user.User;
import user.UserRequest;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserCreationTest {
    User user;
    UserRequest userRequest;
    String accessToken;

    @Before
    public void setup(){
        user = User.getRandomUser();
        userRequest = new UserRequest();
    }

    @After
    public void teardown(){
        Token tokenRequest = new Token(accessToken);
        UserRequest.delete(tokenRequest);
    }
    @Test
    @DisplayName("Успешное создание уникального пользователя")
    public void isUserCreated(){
        accessToken = UserRequest.createSuccess(user)
                .body("success",equalTo(true))
                .extract()
                .path("accessToken");

    }

    @Test
    @DisplayName("Проверка невозможности зарегистрировать уже существующего пользователя")
    public void isUserNotCreated_alreadyExists(){
        UserRequest.createSuccess(user)
                .body("success",equalTo(true));
        accessToken = UserRequest.createForbidden(user)
                .body("message",equalTo("User already exists"))
                .extract()
                .path("accessToken");

    }
    @Test
    @DisplayName("Проверка невозможности зарегистрировать пользователя с незаполненным обязательным полем")
    public void isUserNotCreated_nullField(){
        User userWithouPassword = User.getRandomUserWithoutPassword();
        accessToken = UserRequest.createForbidden(userWithouPassword)
                .body("message",equalTo("Email, password and name are required fields"))
                .extract()
                .path("accessToken");

    }

}
