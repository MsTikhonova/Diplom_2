package config;

public interface Config {
    public static final String PASSWORD = "Password";
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/api";
    public static final String CREATEUSER_ENDPOINT = BASE_URI + "/auth/register";
    public static final String LOGINUSER_ENDPOINT = BASE_URI + "/auth/login";
    public static final String USERINFO_ENDPOINT = BASE_URI + "/auth/user";
    public static final String USERLOGOUT_ENDPOINT = BASE_URI + "/auth/logout";
    public static final String ORDER_ENDPOINT = BASE_URI + "/orders";
    public static final String GETALLORDERS_ENDPOINT = BASE_URI + "/orders/all";
    public static final String INGREDIENTS_ENDPOINT = BASE_URI + "/ingredients";
}
