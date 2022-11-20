import io.qameta.allure.junit4.DisplayName;
import order.Order;
import order.OrderRequest;
import org.junit.Before;
import org.junit.Test;
import user.User;
import user.UserCreds;
import user.UserRequest;

import static org.hamcrest.CoreMatchers.equalTo;

//@RunWith(Parameterized.class)
public class OrderCreationTest {

    User user;
    UserRequest userRequest;
    String accessToken;

    @Before
    public void setup(){
        user = User.getRandomUser();
        userRequest = new UserRequest();
    }

    @Test
    @DisplayName("Успешное создание заказа")
    public void isOrderCreated(){
        accessToken = UserRequest.createSuccess(user)
                .body("success",equalTo(true))
                .extract()
                .path("refreshToken");
        UserCreds creds = UserCreds.from(user);
        UserRequest.logIn(creds);
        Order order;
        order = new Order();
        OrderRequest.orderCreateSuccess(order);
    }

    @Test
    @DisplayName("Ошибка создания заказа без ингридиетом")
    public void isOrderNotCreatedWithoutIngredients(){
        UserLoginTest.isUserLoggedIn();
        Order order;
        order = Order.getOrderWithoutIngredients();
        OrderRequest.orderNotCreatedNoIngredients(order);
    }

    @Test
    @DisplayName("Ошибка создания заказа с неправильным хэшем ингредиентов")
    public void isOrderNotCreatedWrongIngredients(){
        UserLoginTest.isUserLoggedIn();
        Order order;
        order = Order.getWrongIngredientsInOrder();
        OrderRequest.orderNotCreatedWrongIngredients(order);
    }

    @Test
    @DisplayName("Ошибка создания заказа неавторизованным пользователем")
    public void isOrderNotCreatedWithoutLoggingIn(){
        Order order;
        order = Order.getOrderWithoutIngredients();
        OrderRequest.orderNotCreated(order);
    }
}
