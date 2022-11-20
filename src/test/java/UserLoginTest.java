import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import user.User;
import user.UserCreds;
import user.UserRequest;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserLoginTest {
    static User user;
    UserRequest userRequest;
    static String accessToken;

    @Before
    public void setup(){
        user = User.getRandomUser();
        userRequest = new UserRequest();
    }

    @Test
    @DisplayName("Успешная авторизация пользователя")
    public static void isUserLoggedIn(){
        accessToken = UserRequest.createSuccess(user)
                .body("success",equalTo(true))
                .extract()
                .path("refreshToken");
        UserCreds creds = UserCreds.from(user);
        UserRequest.logIn(creds);
    }

    @Test
    @DisplayName("Проверка ошибки авторизации при неправильном логине и пароле")
    public void isUserNotLoggedIn(){
        accessToken = UserRequest.createSuccess(user)
                .body("success",equalTo(true))
                .extract()
                .path("accessToken");
        UserCreds creds = UserCreds.withWrongCredsFrom(user);
        UserRequest.logInUnauthorized(creds);
    }
}
