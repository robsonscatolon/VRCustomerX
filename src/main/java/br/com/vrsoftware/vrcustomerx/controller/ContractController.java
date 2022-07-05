package br.com.vrsoftware.vrcustomerx.controller;

import br.com.vrsoftware.vrcustomerx.dto.ResponseErrorEntityDTO;
import br.com.vrsoftware.vrcustomerx.service.ExportCustomerContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    ExportCustomerContractsService exportCustomerContractsService;

    @PostMapping(value = "/{customerId}")
    public ResponseEntity exportContacts(@PathVariable Integer customerId) throws Exception{

        try {
            return new ResponseEntity(exportCustomerContractsService.execute(customerId), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new ResponseErrorEntityDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
