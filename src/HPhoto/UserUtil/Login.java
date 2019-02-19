package HPhoto.UserUtil;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class Login {
    @RequestMapping(value = "/LoginVerify",method = RequestMethod.POST)
    @ResponseBody
    public String VerifyUser(String username,String passwd){
        System.out.println(username);
        System.out.println(passwd);
        if(!username.isEmpty()&&!passwd.isEmpty())
            if(passwd.equals("admin")&&username.equals("admin"))
                return "admin0";//admin登陆成功
        return "admin1";//admin登陆失败
    }

}
