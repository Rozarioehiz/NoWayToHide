
package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


class DriverRepositoryImplTest {
    private DriverRepositoryImpl driverRepository;
    private Driver driver;

    @BeforeEach
    public void setUp() {
        driverRepository = new DriverRepositoryImpl();
        driver = new Driver();
    }


    @Test
    public void testThatICanSaveADriverAndItIsSavedAsCountOne(){
        assertEquals(0L, driverRepository.count());
        Driver driver = new Driver();
        driverRepository.save(driver);
        assertEquals(1L, driverRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoDrivers_countIsTwo() {
        assertEquals(0L, driverRepository.count());
        Driver driverTwo = new Driver();
        driverRepository.save(driverTwo);
        driverRepository.save(driver);
        assertEquals(2L, driverRepository.count());
    }

    @Test
    public void testThatWhenISaveDriver_idIsSet() {
        Driver savedDriver = driverRepository.save(driver);
        assertEquals(1, savedDriver.getId());
    }

    @Test
    public void testThatWhenIFindById_driverIsFound() {
        Driver savedDriver = driverRepository.save(driver);
        int driverId = savedDriver.getId();
        assertEquals(savedDriver, driverRepository.findById(driverId));
    }

    @Test
    public void testThatWhenIFindByInvalidId_errorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> driverRepository.findById(-1));
    }

    @Test
    public void testThatWhenIFindAll_allDriversAreFound() {
        Driver driverTwo = new Driver();
        Driver driverThree = new Driver();
        Driver[] allDrivers = {driver, driverTwo, driverThree};
        for (Driver d : allDrivers) {
            driverRepository.save(d);
        }

        List<Driver> foundDrivers = driverRepository.findAll();
        assertEquals(3, foundDrivers.size());
        for (int i = 0; i < allDrivers.length; i++) {
            assertEquals(allDrivers[i], foundDrivers.get(i));
        }
    }

    @Test
    public void testThatWhenIFindAllAndNoDriverIsSaved_errorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> driverRepository.findAll());
    }

    @Test
    public void testThatWhenIDeleteDriver_driverIsDeleted() {
        Driver savedDriver = driverRepository.save(driver);
        int driverId = savedDriver.getId();
        assertEquals(1L, driverRepository.count());

        driverRepository.delete(driverId);

        assertEquals(0L, driverRepository.count());
    }
}
