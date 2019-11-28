package model;

import java.sql.Timestamp;
import java.util.Objects;

public class Advertisement {
    private long id;
    private String title;
    private int price;
    private Timestamp timestamp;
    private User user;
    private String description;
    private String carProducent;
    private String carModel;
    private String fuelType;
    private String carType;
    private int engineCapacity;
    private int yearOfProduction;


    public Advertisement (){}

    public Advertisement (Advertisement advertisement)
    {
        this.id = advertisement.id;
        this.title = advertisement.title;
        this.timestamp = new Timestamp(advertisement.timestamp.getTime());
        this.user = new User(advertisement.user);
        this.description = advertisement.description;
        this.price = advertisement.price;
        this.carProducent = advertisement.carProducent;
        this.carModel = advertisement.carModel;
        this.fuelType = advertisement.fuelType;
        this.carType = advertisement.carType;
        this.engineCapacity = advertisement.engineCapacity;
        this.yearOfProduction = advertisement.yearOfProduction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarProducent() {
        return carProducent;
    }

    public void setCarProducent(String carProducent) {
        this.carProducent = carProducent;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }



    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return id == that.id &&
                price == that.price &&
                engineCapacity == that.engineCapacity &&
                yearOfProduction == that.yearOfProduction &&
                Objects.equals(title, that.title) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(user, that.user) &&
                Objects.equals(description, that.description) &&
                Objects.equals(carProducent, that.carProducent) &&
                Objects.equals(carModel, that.carModel) &&
                fuelType == that.fuelType &&
                carType == that.carType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, timestamp, user, description, carProducent, carModel, fuelType, carType, engineCapacity, yearOfProduction);
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", timestamp=" + timestamp +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", carProducent='" + carProducent + '\'' +
                ", carModel='" + carModel + '\'' +
                ", fuelType=" + fuelType +
                ", carType=" + carType +
                ", engineCapacity=" + engineCapacity +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
