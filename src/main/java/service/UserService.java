package service;

import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {

    private UserService() {
    }

    public static class UserServiceHolder {
        public static final UserService HOLDER_INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return UserServiceHolder.HOLDER_INSTANCE;
    }


    /* хранилище данных */
    private Map<Long, User> dataBase = Collections.synchronizedMap(new HashMap<>());
    /* счетчик id */
    private AtomicLong maxId = new AtomicLong(0);
    /* список авторизованных пользователей */
    private Map<Long, User> authMap = Collections.synchronizedMap(new HashMap<>());


    public List<User> getAllUsers() {
        List<User> list_db = new ArrayList<>(dataBase.values());
        return list_db;
    }

    public User getUserById(Long id) {
        return dataBase.get(id);
    }

    public boolean addUser(User user) {
        if (!isExistsThisUser(user)) {
            dataBase.put(user.getId(), user);
            return true;
        } // проверка по email должна быть!!!

        else return false;
    }

    public void deleteAllUser() {
        dataBase.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserService that = (UserService) o;
        return Objects.equals(dataBase, that.dataBase) &&
                Objects.equals(maxId, that.maxId) &&
                Objects.equals(authMap, that.authMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataBase, maxId, authMap);
    }

    public boolean isExistsThisUser(User user) {
        user.setId(maxId.incrementAndGet());
        int count = 0;
        for (Map.Entry<Long, User> pair : dataBase.entrySet()) {
            //получение «пары» элементов
            Long id = pair.getKey();            //ключ
            if (pair.getValue().getEmail().equals(user.getEmail())) {
                user.setId(id);
                count++;
                break;
            }
        }      //значение
        if (count == 1) {
            return true;
        } else return false;
    }

    public List<User> getAllAuth() {
        List<User> list_au = new ArrayList<>(authMap.values());
        return list_au;
    }

    public boolean authUser(User user) {
        if (isExistsThisUser(user)) {
            String password = dataBase.get(user.getId()).getPassword();
            if (password.equals(user.getPassword())) {
                authMap.put(user.getId(), user);
                return true;
            }
            // authMap.put(user.getId()) return true;
        }
        return false;
    }

    public void logoutAllUsers() {
        authMap.clear();
    }

    public boolean isUserAuthById(Long id) {
        if (authMap.containsKey(id)) {
            return true;
        } else return false;

    }

}
