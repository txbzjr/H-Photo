package sample.UserUtil;


import javafx.scene.control.Alert;
import sample.HttpUtil.HttpClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Login {
    private String username,password;
    private String result = "";
    private int HttpCode = 0;
    private final static String VerifyUserUrl = "http://localhost:8080/MyJavaFXServer_war_exploded/LoginVerify";
    public Login(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public int getHttpCode() {
        return HttpCode;
    }

    public Boolean VerifyInfo(){
        return !username.isEmpty() && !password.isEmpty();
    }
    public String VerifyUser(){
        String param = "username="+username+"&passwd="+password;
        HttpClient httpClient = new HttpClient(VerifyUserUrl);
        result = httpClient.doPost(param);
        this.HttpCode = httpClient.getPostHttpCode();
        return result;
    }

    public String getResult() {
        return result;
    }
}
