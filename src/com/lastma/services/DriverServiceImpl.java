package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.OfficerRepository;

public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository ;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void register(String fullName, String email, String password) {
        Driver newDriver = new Driver();
        newDriver.setFullName(fullName);
        newDriver.setEmail(email);
        newDriver.setPassword(password);
        driverRepository.save(newDriver);

    }

    @Override
    public Driver save(Driver driver) {
        return null;
    }
}
