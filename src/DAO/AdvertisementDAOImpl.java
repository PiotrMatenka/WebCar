package DAO;

import model.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvertisementDAOImpl implements AdvertisementDAO {
    private final static String CREATE_ADVERTISEMENT = "INSERT INTO advertisement(title, date, user_id, description, price, car_producent,car_model, fuel_type, engine_capacity, year_of_production, car_type)" +
            " VALUES (:title, :date, :user_id, :description, :price, :car_producent, :car_model, :fuel_type, :engine_capacity, :year_of_production, :car_type);";
    private final static String READ_ADVERTISEMENT = "SELECT user.user_id, username, email, password, city, is_active, advertisement_id, title, date, description, price , car_producent,car_model, fuel_type, engine_capacity, year_of_production, car_type FROM advertisement " +
            "LEFT JOIN user ON advertisement.user_id=user.user_id WHERE advertisement_id= :advertisement_id;";
    private final static String UPDATE_ADVERSIMENT = "UPDATE advertisement SET title = :title, user_id= :user_id, description= :description, price= :price ," +
            " car_producent= :car_producent,car_model= :car_model, fuel_type= :fuel_type, engine_capacity= :engine_capacity, year_of_production = :year_of_production, car_type= :car_type"+
            " WHERE advertisement_id = :advertisement_id;";
    private final static String READ_ALL_ADVERTISEMENTS = "SELECT user.user_id, username, email, password, is_active, city, advertisement_id, title, date, description, price, car_producent, car_model, fuel_type, engine_capacity, year_of_production, car_type "
            + "FROM advertisement LEFT JOIN user ON advertisement.user_id = user.user_id; ";


    private NamedParameterJdbcTemplate template;
    public AdvertisementDAOImpl ()
    {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }
    @Override
    public Advertisement create(Advertisement advertisement) {
        Advertisement resultAdvertisement = new Advertisement(advertisement);
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object>paramMap = new HashMap<String, Object>();
        paramMap.put("title", advertisement.getTitle());
        paramMap.put("date", advertisement.getTimestamp());
        paramMap.put("user_id", advertisement.getUser().getId());
        paramMap.put("description", advertisement.getDescription());
        paramMap.put("price", advertisement.getPrice());
        paramMap.put("car_producent", advertisement.getCarProducent());
        paramMap.put("car_model", advertisement.getCarModel());
        paramMap.put("fuel_type", advertisement.getFuelType());
        paramMap.put("engine_capacity", advertisement.getEngineCapacity());
        paramMap.put("year_of_production", advertisement.getYearOfProduction());
        paramMap.put("car_type", advertisement.getCarType());
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_ADVERTISEMENT, paramSource, holder);
        if (update>0)
        {
            resultAdvertisement.setId((Long)holder.getKey());
        }return resultAdvertisement;
    }

    @Override
    public Advertisement read(Long primarykey) {
        SqlParameterSource paramSource = new MapSqlParameterSource("advertisement_id", primarykey);
        Advertisement advertisement = template.queryForObject(READ_ADVERTISEMENT, paramSource, new AdvertisementRowMapper());
        return advertisement;
    }


    @Override
    public boolean update(Advertisement advertisement) {
        boolean result = false;
        Map<String, Object>paramMap = new HashMap<String, Object>();
        paramMap.put("title", advertisement.getTitle());
        paramMap.put("date", advertisement.getTimestamp());
        paramMap.put("user_id", advertisement.getUser().getId());
        paramMap.put("description", advertisement.getDescription());
        paramMap.put("price", advertisement.getPrice());
        paramMap.put("car_producent", advertisement.getCarProducent());
        paramMap.put("car_model", advertisement.getCarModel());
        paramMap.put("fuel_type", advertisement.getFuelType());
        paramMap.put("engine_capacity", advertisement.getEngineCapacity());
        paramMap.put("year_of_production", advertisement.getYearOfProduction());
        paramMap.put("car_type", advertisement.getCarType());
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        int update = template.update(UPDATE_ADVERSIMENT, paramSource);
        if (update>0)
        {
            result = true;
        }return result;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Advertisement> getAll()
    {
        List<Advertisement>advertisements = template.query(READ_ALL_ADVERTISEMENTS, new AdvertisementRowMapper());
        return advertisements;
    }
    private class AdvertisementRowMapper implements RowMapper<Advertisement>
    {

        @Override
        public Advertisement mapRow(ResultSet resultSet, int i) throws SQLException {
            Advertisement advertisement = new Advertisement();
            advertisement.setId(resultSet.getLong("advertisement_id"));
            advertisement.setTitle(resultSet.getString("title"));
            advertisement.setTimestamp(resultSet.getTimestamp("date"));
            advertisement.setDescription(resultSet.getString("description"));
            advertisement.setPrice(resultSet.getInt("price"));
            advertisement.setCarProducent(resultSet.getString("car_producent"));
            advertisement.setCarModel(resultSet.getString("car_model"));
            advertisement.setFuelType(resultSet.getString("fuel_type"));
            advertisement.setEngineCapacity(resultSet.getInt("engine_capacity"));
            advertisement.setYearOfProduction(resultSet.getInt("year_of_production"));
            advertisement.setCarType(resultSet.getString("car_type"));
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setCity(resultSet.getString("city"));
            advertisement.setUser(user);
            return advertisement;
        }
    }
}