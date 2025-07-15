package ali.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ali.AppConfig.AppConfig;
import ali.model.User;

public class LoginService {

    public void login() {
        
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserServices userService = context.getBean(UserServices.class);

    }
}
