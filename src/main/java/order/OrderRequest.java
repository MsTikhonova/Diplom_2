package order;

import config.Config;
import io.restassured.response.ValidatableResponse;
import user.HeaderSpec;
import order.Order;
import user.User;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;

public class OrderRequest extends HeaderSpec implements Config {

    public static ValidatableResponse orderCreateSuccess(Order order) {
        return  getSpec()
                .body(order)
                .when()
                .post(ORDER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .body("success",equalTo(true));

    }

    public static ValidatableResponse orderNotCreated(Order order) {
        return  getSpec()
                .body(order)
                .when()
                .post(ORDER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .body("success",equalTo(false));

    }

    public static ValidatableResponse orderNotCreatedNoIngredients(Order order) {
        return  getSpec()
                .body(order)
                .when()
                .post(ORDER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .statusCode(400);

    }

    public static ValidatableResponse orderNotCreatedWrongIngredients(Order order) {
        return  getSpec()
                .body(order)
                .when()
                .post(ORDER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .statusCode(500);

    }
}
