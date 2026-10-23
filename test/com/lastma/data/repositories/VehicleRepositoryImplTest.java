package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import com.lastma.data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


class VehicleRepositoryImplTest {



        private VehicleRepositoryImpl vehicleRepository;
        private Vehicle vehicle;

        @BeforeEach
        public void setUp() {
           vehicleRepository = new VehicleRepositoryImpl();
            vehicle = new Vehicle();

        }

        @Test
        public void testThatWhenISaveOneVehicleItIsSavedAsCountOne() {
            assertEquals(0L, vehicleRepository.count());
            Vehicle vehicle = new Vehicle();
            vehicleRepository.save(vehicle);
            assertEquals(1L, vehicleRepository.count());
        }


        @Test
        public void testThatWhenISaveVehicle_IdIsSet() {
            Vehicle savedVehicle = vehicleRepository.save(vehicle);
            assertEquals(1, savedVehicle.getId());

        }

        @Test
        public void testThatWhenIFindById_VehicleIsFound() {
            Vehicle savedVehicle = vehicleRepository.save(vehicle);
            int vehicleId = savedVehicle.getId();
            assertEquals(savedVehicle, vehicleRepository.findById(vehicleId));
        }

        @Test
        public void testThatWhenIFindByInvalidId_ErrorIsThrown() {
            assertThrows(IllegalArgumentException.class, () -> vehicleRepository.findById(-1));
        }


        @Test
        public void testThatWhenIFindAll_AllVehiclesAreFound() {
            Vehicle vehicleTwo = new Vehicle();
            Vehicle vehicleThree = new Vehicle();
            Vehicle[] allVehicles = {vehicle,vehicleTwo, vehicleThree};
            for (Vehicle v : allVehicles) {
                vehicleRepository.save(v);
            }

            List<Vehicle> foundVehicle = vehicleRepository.findAll();
            assertEquals(3, foundVehicle.size());
            for (int count = 0; count < allVehicles.length; count++) {
                assertEquals(allVehicles [count], foundVehicle.get(count));
            }
        }

        @Test
        public void testThatWhenIFindAllAndNoVehicleIsSaved_ErrorIsThrown() {
            assertThrows(IllegalArgumentException.class, () -> vehicleRepository.findAll());
        }


        @Test
        public void testThatWhenIDeleteVehicle_vehicleIsDeleted() {
            Vehicle savedVehicle = vehicleRepository.save(vehicle);
            int vehicleId = savedVehicle.getId();
            assertEquals(1L, vehicleRepository.count());

           vehicleRepository.delete(vehicleId);

            assertEquals(0L,vehicleRepository.count());
        }
    }







