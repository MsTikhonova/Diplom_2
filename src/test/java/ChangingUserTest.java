import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import user.User;
import user.UserCreds;
import user.UserRequest;
import user.UserUpdate;

import static org.hamcrest.CoreMatchers.equalTo;

public class ChangingUserTest {

    User user;
    UserRequest userRequest;
    String accessToken;
    UserUpdate userUpdated;

    @Before
    public void setup(){
        user = User.getRandomUser();
        userRequest = new UserRequest();
    }

    @Test
    @DisplayName("Успешное обновление данных")
    public void isEmailUpdated(){
        UserRequest.createSuccess(user)
                .body("success",equalTo(true));
        UserCreds creds = UserCreds.from(user);
        accessToken = UserRequest.logIn(creds)
                .extract()
                .path("accessToken");
        userUpdated = new UserUpdate(accessToken,"testemail@gmail.com");
        UserRequest.updateUser(userUpdated);
    }

    @Test
    @DisplayName("Проверка ошибки обновления данных для неавторизованного пользователя")
    public void isEmailNotUpdated(){
        userUpdated = new UserUpdate("testemail@gmail.com");
        UserRequest.updateUnauthorizedUser(userUpdated);
    }
}
