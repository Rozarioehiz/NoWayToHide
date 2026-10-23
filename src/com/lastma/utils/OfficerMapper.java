package com.lastma.utils;

import com.lastma.data.models.Officer;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.FindOfficerResponse;

public class OfficerMapper {
    public static Officer map(RegisterOfficerRequest request){
        Officer officer = new Officer();

        officer.setEmail(request.getEmail());
        officer.setFullName(request.getFullName());
        officer.setPassword(request.getPassword());

        return officer;
    }

    public static FindOfficerResponse map(Officer savedOfficer, String message){
        FindOfficerResponse foundOfficer = new FindOfficerResponse();
       foundOfficer.setFullName(savedOfficer.getFullName());

       foundOfficer.setMessage("registered successfully");
       return  foundOfficer;
    }

}
