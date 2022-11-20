import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import user.*;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetUserOrdersTest {

    User user;
    UserRequest userRequest;
    String token;

    @Before
    public void setup(){
        user = User.getRandomUser();
        userRequest = new UserRequest();
    }

    @Test
    @DisplayName("Успешное получение заказов пользователя")
    public void isEmailUpdated(){
        UserRequest.createSuccess(user)
                .body("success",equalTo(true));
        UserCreds creds = UserCreds.from(user);
        token = UserRequest.logIn(creds)
                .extract()
                .path("accessToken");
        Token accessToken = new Token(token);
        UserRequest.getUserOrders(accessToken);
    }

    @Test
    @DisplayName("Проверка ошибки получение заказов неавторизованного пользователя")
    public void isEmailNotUpdated(){
        UserRequest.getUserOrdersUnauthorized();
    }


}
