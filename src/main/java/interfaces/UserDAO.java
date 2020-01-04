package interfaces;


import model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUser();

    public void addUser(User user);

    public void editUser(User user);

    public void delUser(String name);

}
