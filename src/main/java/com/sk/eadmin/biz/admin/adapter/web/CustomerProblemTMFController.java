package com.sk.eadmin.biz.admin.adapter.web;


import org.springframework.web.bind.annotation.*;

import com.sk.eadmin.biz.admin.port.usecase.CustomerProblemCommandUsecase;
import com.sk.eadmin.biz.admin.port.usecase.CustomerProblemQueryUsecase;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/tmf-api/v1/customer/troubleTicket")
@RequiredArgsConstructor
public class CustomerProblemTMFController {
    
    private final CustomerProblemCommandUsecase customerProblemCommandUsecase;
    private final CustomerProblemQueryUsecase customerProblemQueryUsecase;

}