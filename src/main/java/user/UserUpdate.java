package user;

public class UserUpdate {
    String accessToken;
    String email;


    public UserUpdate(String accessToken,
    String email){
        this.accessToken = accessToken;
        this.email = email;
    }
    public UserUpdate(
                      String email){
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
