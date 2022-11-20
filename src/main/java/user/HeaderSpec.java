package user;

import io.restassured.specification.RequestSpecification;
import config.Config;
import static io.restassured.RestAssured.given;

public class HeaderSpec {

    public static RequestSpecification getSpec(){
        return given().log().all()
                .header("Content-Type", "application/json")
                .baseUri(Config.BASE_URI);
    }
}
