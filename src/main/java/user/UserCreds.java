package user;

public class UserCreds {
    private String email;
    private String password;

    public UserCreds(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public UserCreds(String password) {
        this.password = password;
    }

    public static UserCreds from(User user) {
        return new UserCreds(user.getEmail(), user.getPassword());
    }

    public static UserCreds withoutLoginFrom(User user) {
        return new UserCreds(user.getPassword());
    }

    public static UserCreds withWrongCredsFrom(User user) {
        return new UserCreds("1", "1");
    }
}
