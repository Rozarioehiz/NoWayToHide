package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;

import java.util.ArrayList;
import java.util.List;

public class OfficerRepositoryImpl implements OfficerRepository {

    private List<Officer> officers = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public Officer save(Officer officer) {
        officer.setId(++idCounter);
        officers.add(officer);
        return officer;
    }

    @Override
    public long count() {
        return officers.size();
    }

    @Override
    public Officer findById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        for (Officer officer : officers) {
            if (officer.getId() == id) {
                return officer;
            }
        }
        return null;
    }

    @Override
    public List<Officer> findAll() {
        if (officers.isEmpty()) throw new IllegalArgumentException("No drivers found");
        return officers;
    }

    @Override
    public void delete(int id) {
        Officer foundOfficer = findById(id);
        if (foundOfficer != null) {
            officers.remove(foundOfficer);
        }
    }

    @Override
    public void deleteAll() {
        officers.clear();
    }

    @Override
    public boolean exitById(int driverId) {
        return false;
    }

    @Override
    public boolean existById(int id) {
        for (Officer officer : officers) {
            if (officer.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void register(String fullName, String mail, String password) {

    }


}
