package DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, PK extends Serializable> {
    //CRUD
    T create (T newObject);
    T read (PK primarykey);
    boolean update (T updateObject);
    boolean delete (PK key);
    List<T> getAll();
}
