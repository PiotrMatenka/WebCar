package Service;

import DAO.AdvertisementDAO;
import DAO.DAOfactory;
import model.Advertisement;


import model.User;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class AdvertisementService {
    public void addAdvertisement (String title, User user, String description, int price, String carProducent, String carModel, String fuelType, int engineCapacity, int yearOfProduction, String carType)
    {
        Advertisement advertisement = createAdvertisementObject(title, user, description, price, carProducent, carModel, fuelType, engineCapacity, yearOfProduction, carType);
        DAOfactory factory = DAOfactory.getDAOFactory();
        AdvertisementDAO advertisementDAO = factory.getAdvertisementDAO();
        advertisementDAO.create(advertisement);
    }
    private Advertisement createAdvertisementObject (String title, User user, String description, int price, String carProducent, String carModel, String fuelType, int engineCapacity, int yearOfProduction, String carType)
    {
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(title);
        User userCopy = new User(user);
        advertisement.setUser(userCopy);
        advertisement.setDescription(description);
        advertisement.setPrice(price);
        advertisement.setTimestamp(new Timestamp(new Date().getTime()));
        advertisement.setCarProducent(carProducent);
        advertisement.setCarModel(carModel);
        advertisement.setFuelType(fuelType);
        advertisement.setEngineCapacity(engineCapacity);
        advertisement.setYearOfProduction(yearOfProduction);
        advertisement.setCarType(carType);
        return advertisement;
    }
    public Advertisement getAdvertisementById (Long advertisementId)
    {
        DAOfactory factory = DAOfactory.getDAOFactory();
        AdvertisementDAO advertisementDAO = factory.getAdvertisementDAO();
        Advertisement advertisement = advertisementDAO.read(advertisementId);
        return advertisement;
    }



    public List <Advertisement> getAllAdvertisements ()
    {
        return getAllAdvertisements(null);
    }
    public List <Advertisement> getAllAdvertisements (Comparator <Advertisement> comparator)
    {
        DAOfactory daOfactory = DAOfactory.getDAOFactory();
        AdvertisementDAO advertisementDAO = daOfactory.getAdvertisementDAO();
        List <Advertisement> advertisements = advertisementDAO.getAll();
        if (comparator !=null && advertisements !=null)
        {
            advertisements.sort(comparator);
        }return advertisements;
    }
    public boolean updateAdvertisement (Advertisement advertisement)
    {
        DAOfactory factory = DAOfactory.getDAOFactory();
        AdvertisementDAO advertisementDAO = factory.getAdvertisementDAO();
        boolean result = advertisementDAO.update(advertisement);
        return result;
    }

}
