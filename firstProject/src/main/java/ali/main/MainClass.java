package ali.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ali.AppConfig.AppConfig;
import ali.Services.LoginService;
import ali.Services.UserServices;
import ali.model.User;

public class MainClass {
    public static void main(String[] args) {
    
    ApplicationContext context= new AnnotationConfigApplicationContext (AppConfig.class);
    UserServices userService =context.getBean(UserServices.class);
    for(User user: userService.getUserList()){
        System.out.println(user);
    }

    LoginService loginService= new LoginService();
    loginService.login();
    }
}
