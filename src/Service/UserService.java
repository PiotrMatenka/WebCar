package Service;

import DAO.DAOfactory;
import DAO.UserDAO;
import model.User;


public class UserService {
    public void addUser (String username, String email, String password, String city)
    {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setCity(city);
        user.setActive(true);
        DAOfactory factory = DAOfactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.create(user);
    }

    public User getUserById (long userId)
    {
        DAOfactory factory = DAOfactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.read(userId);
        return user;
    }
    public User getUserByUsername (String username)
    {
        DAOfactory factory = DAOfactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getUserByUsername(username);
        return user;
    }


}
