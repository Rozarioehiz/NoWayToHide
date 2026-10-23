package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setId((++idCounter));
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public long count() {
        return vehicles.size();
    }

    @Override
    public Vehicle findById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        if (vehicles.isEmpty()) throw new IllegalArgumentException("No tickets found");
        return vehicles;
    }

    @Override
    public void delete() {

    }

    @Override
    public void delete(int id) {
        Vehicle foundVehicle = findById(id);
        if (foundVehicle != null) {
            vehicles.remove(foundVehicle);
        }
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public boolean exitById(int vehicleId) {
        return false;
    }

    @Override
    public boolean existById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return true;
            }
        }
        return false;
    }


}
