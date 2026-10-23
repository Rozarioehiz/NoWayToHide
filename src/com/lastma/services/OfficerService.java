
package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.FindOfficerResponse;

import java.util.List;

public interface OfficerService {

    FindOfficerResponse register(RegisterOfficerRequest request);


}




















































//package com.lastma.services;



//
//import com.lastma.data.models.Officer;
//import com.lastma.data.repositories.OfficerRepository;
//
//
//public interface OfficerService {
//    private final OfficerRepository repository;
//
//    public OfficerService(OfficerRepository repository) {
//        this.repository = repository;
//    }
//
//    public void register(Officer officer) {
//        repository.save(officer);
//    }
//
//}
//
//
