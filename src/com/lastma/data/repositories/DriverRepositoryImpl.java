package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepository{

    private List<Driver> drivers = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public Driver save(Driver driver) {
        driver.setId(++idCounter);
        drivers.add(driver);
        return driver;
    }

    @Override
    public long count() {
        return drivers.size();
    }

    @Override
    public Driver findById(int id) {
        for (Driver driver : drivers) {
            if (driver.getId() == id) {
                return driver;
            }
        }
        return null;
    }

    @Override
    public List<Driver> findAll() {
        if (drivers.isEmpty()) throw new IllegalArgumentException("No drivers found");
        return drivers;
    }

    @Override
    public void delete(int id) {
        Driver foundDriver = findById(id);
        if (foundDriver != null) {
            drivers.remove(foundDriver);
        }
    }

    @Override
    public void deleteAll() {
        drivers.clear();
    }

    @Override
    public boolean exitById(int driverId) {
        return false;
    }

    @Override
    public boolean existById(int id) {
        for (Driver driver : drivers) {
            if (driver.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
