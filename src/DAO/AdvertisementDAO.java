package DAO;

import model.Advertisement;

import java.util.List;

public interface AdvertisementDAO extends GenericDAO <Advertisement, Long> {
    List <Advertisement> getAll();
}
