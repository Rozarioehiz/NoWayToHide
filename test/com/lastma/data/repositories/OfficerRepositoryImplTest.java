package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class OfficerRepositoryImplTest {
    private OfficerRepositoryImpl officerRepository;
    private Officer officer;

    @BeforeEach
    public void setUp() {
        officerRepository = new OfficerRepositoryImpl();
        officer = new Officer();

    }

    @Test
    public void testThatWhenISaveOneOfficerItIsSavedAsCountOne() {
        assertEquals(0L, officerRepository.count());
        Officer officer = new Officer();
        officerRepository.save(officer);
        assertEquals(1L, officerRepository.count());
    }


    @Test
    public void testThatWhenISaveOfficer_IdIsSet() {
        Officer savedOfficer = officerRepository.save(officer);
        assertEquals(1, savedOfficer.getId());

    }

    @Test
    public void testThatWhenIFindById_OfficerIsFound() {
        Officer savedOfficer = officerRepository.save(officer);
        int officerId = savedOfficer.getId();
        assertEquals(savedOfficer, officerRepository.findById(officerId));
    }

    @Test
    public void testThatWhenIFindByInvalidId_ErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> officerRepository.findById(-1));
    }


    @Test
    public void testThatWhenIFindAll_AllOfficersAreFound() {
        Officer officerTwo = new Officer();
        Officer officerThree = new Officer();
        Officer[] allOfficers = {officer, officerTwo, officerThree};
        for (Officer o : allOfficers) {
            officerRepository.save(o);
        }

        List<Officer> foundDrivers = officerRepository.findAll();
        assertEquals(3, foundDrivers.size());
        for (int count = 0; count < allOfficers.length; count++) {
            assertEquals(allOfficers
                    [count], foundDrivers.get(count));
        }
    }

    @Test
    public void testThatWhenIFindAllAndNoOfficerIsSaved_ErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> officerRepository.findAll());
    }


    @Test
    public void testThatWhenIDeleteOfficer_officerIsDeleted() {
        Officer savedOfficer = officerRepository.save(officer);
        int driverId = savedOfficer.getId();
        assertEquals(1L, officerRepository.count());

        officerRepository.delete(driverId);

        assertEquals(0L, officerRepository.count());
    }
}





