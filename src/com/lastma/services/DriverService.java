package com.lastma.services;

import com.lastma.data.models.Driver;

public interface DriverService {
    void register(String fullName, String email, String password);
        Driver save(Driver driver);
}
