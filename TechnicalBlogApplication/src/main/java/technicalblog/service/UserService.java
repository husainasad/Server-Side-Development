package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.User;

@Service
public class UserService {
    public static boolean login(User user) {
        if(user.getUsername().equals("valid")) {
            return true;
        }
        else {
            return false;
        }
    }
}
