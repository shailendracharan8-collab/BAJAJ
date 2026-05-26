package com.shailendra.bfhl.service;

import com.shailendra.bfhl.dto.RequestDTO;
import com.shailendra.bfhl.dto.ResponseDTO;

public interface BFHLService {

    ResponseDTO processData(RequestDTO request);

}