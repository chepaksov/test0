package web.dao;



import org.springframework.beans.factory.annotation.Autowired;
import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getUser();
    void update(User user);

}
