package service;

import model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl {
    private static int user_id =0;
    public List<User> UserList;


    {
        UserList = new ArrayList<>();
        UserList.add(new User(++user_id, "Liza", "Glazneva", "glaz.mail"));
        UserList.add(new User(++user_id, "Dasha", "Galushko", "gal.mail"));
        UserList.add(new User(++user_id, "Anna", "Demidova", "nuta.mail"));
        UserList.add(new User(++user_id, "Sasha", "Bortich", "borabora.mail"));
    }
    public List<User> userList(){
        return UserList;
    }
    public User findUserBuId(int id){
        return UserList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public void save(User user){
        user.setId(++user_id);
        UserList.add(user);
    }
    public void update(int id, User updatedUser){
        User userAfterUpdate = findUserBuId(id);
        userAfterUpdate.setName(updatedUser.getName());
        userAfterUpdate.setLastName(updatedUser.getLastName());
        userAfterUpdate.setEmail(updatedUser.getEmail());
    }
    public void delete(int id){
        UserList.removeIf(user -> user.getId()==id);
    }
}
