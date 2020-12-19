package id.ac.polinema.maskoki.models;

import com.google.gson.annotations.SerializedName;

public class AccountModel {
    @SerializedName("id")
    private Integer id;

    @SerializedName("username")
    private String username;

    @SerializedName("name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("password")
    private String password;

    @SerializedName("token")
    private String token;

    public AccountModel() {
    }

    public AccountModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }
}
