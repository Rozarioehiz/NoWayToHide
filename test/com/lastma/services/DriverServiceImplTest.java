package com.lastma.services;


import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceImplTest {

        private DriverService driverService;
        private DriverRepository driverRepository;

        @BeforeEach
        void setUp() {
            driverRepository = new DriverRepositoryImpl();
            driverService = new DriverServiceImpl(driverRepository);
        }


        @Test
        public void registerOfficer_officerCountIsOneTest(){
            assertEquals(0L, DriverRepository.count());
            driverService.register("name", "email", "password");
            assertEquals(1L, DriverRepository.count());
        }

    }

