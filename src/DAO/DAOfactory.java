package DAO;

public abstract class DAOfactory {
    public static final int MYSQL_DAO_FACTORY = 1;

    public abstract UserDAO getUserDAO();
    public abstract AdvertisementDAO getAdvertisementDAO();

    public static DAOfactory getDAOFactory() {
        DAOfactory factory = null;
        try {
            factory = getDAOFactory(MYSQL_DAO_FACTORY);
        } catch (NoSuchDbException e) {
            e.printStackTrace();
        }
        return factory;
    }

    private static DAOfactory getDAOFactory (int type) throws NoSuchDbException
    {
        switch (type){
            case MYSQL_DAO_FACTORY:
                return new MysqlDAOFactory();
            default:
                throw new NoSuchDbException();
        }

    }
}
