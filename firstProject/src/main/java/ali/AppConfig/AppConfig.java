package ali.AppConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ali.Services.UserServices;
import ali.model.User;

@Configuration
public class AppConfig {

    @Bean
    public UserServices userService() {
        UserServices UserServices = new UserServices();

        List<User> userlist = new ArrayList<>();
        userlist.add(new User("Ali"));
        userlist.add(new User("Tevfik"));

        UserServices.setUserList(userlist);

        return UserServices;
    }

}
