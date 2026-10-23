package com.lastma.services;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class OfficerServiceImplTest {
     private OfficerService officerService;
     private OfficerRepository officerRepository;

     @BeforeEach
     void setUp() {
         officerRepository = new OfficerRepositoryImpl();
         officerService = new OfficerServiceImpl(officerRepository);
     }


     private RegisterOfficerRequest request(String email, String password) {
         RegisterOfficerRequest request = new RegisterOfficerRequest();
         request.setFullName("Ehi");
         request.setEmail(email);
         request.setPassword(password);
         return request;
     }


     @Test
     public void registerOfficer_officerCountIsOneTest() {
         assertEquals(0L, officerRepository.count());
         officerService.register(request("ehiz@gmail.com", "password"));
         assertEquals(1L, officerRepository.count());
     }


 }