package user;
import config.Config;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserRequest extends HeaderSpec implements Config {

    public static ValidatableResponse createSuccess(User user) {
        return  getSpec()
                .body(user)
                .when()
                .post(CREATEUSER_ENDPOINT)
                .then().log().all();

    }

    public static ValidatableResponse createForbidden(User user) {
        return getSpec()
                .body(user)
                .when()
                .post(CREATEUSER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .statusCode(403);

    }

    public static ValidatableResponse logIn(UserCreds creds) {
        return getSpec()
                .body(creds)
                .when()
                .post(LOGINUSER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .body("success",equalTo(true));

    }

    public static ValidatableResponse logInUnauthorized(UserCreds creds) {
        return getSpec()
                .body(creds)
                .when()
                .post(LOGINUSER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .statusCode(401);

    }

    public static ValidatableResponse getUserOrders(Token token) {
        return getSpec()
                .body(token)
                .when()
                .get(ORDER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .body("success",equalTo(true));

    }

    public static ValidatableResponse getUserOrdersUnauthorized() {
        return getSpec()
                .body("")
                .when()
                .get(ORDER_ENDPOINT)
                .then().log().all()
                .assertThat()
                .statusCode(401);

    }

    public static boolean updateUser(UserUpdate userupdate) {
        return getSpec()
                .body(userupdate)
                .when()
                .patch(USERINFO_ENDPOINT)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");

    }

    public static ValidatableResponse updateUnauthorizedUser(UserUpdate userupdate) {
        return getSpec()
                .body(userupdate)
                .when()
                .patch(USERINFO_ENDPOINT)
                .then().log().all()
                .assertThat()
                .statusCode(401);

    }

    public static boolean logOut(Token token) {
        return getSpec()
                .body(token)
                .when()
                .post(USERLOGOUT_ENDPOINT)
                .then().log().all()
                .assertThat()
                .body("message",equalTo("Successful logout"))
                .extract()
                .path("success");

    }

    public static ValidatableResponse delete(Token token) {
        return getSpec()
                .body(token)
                .when()
                .delete(USERINFO_ENDPOINT)
                .then().log().all()
                .assertThat()
                .body("success",equalTo(true));

    }


}
