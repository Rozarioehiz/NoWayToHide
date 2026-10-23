
package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.FindOfficerResponse;

import java.util.List;

import static com.lastma.utils.OfficerMapper.map;

public class OfficerServiceImpl implements OfficerService {


   private final OfficerRepository officerRepository = new OfficerRepositoryImpl();


    @Override
    public FindOfficerResponse  register(RegisterOfficerRequest request) {

        Officer newOfficer = map(request);

        Officer savedOfficer = officerRepository.save(newOfficer);



        return map(savedOfficer, "registered successful" );

    }


//    @Override
//   public Officer findById(int id) {
//        return null;
//   }
//
//    @Override
//    public List<Officer> findAll() {
//       return List.of();
//    }





}