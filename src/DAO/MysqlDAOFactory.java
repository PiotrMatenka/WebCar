package DAO;

public class MysqlDAOFactory extends DAOfactory {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public AdvertisementDAO getAdvertisementDAO() {
        return new AdvertisementDAOImpl();
    }


}
