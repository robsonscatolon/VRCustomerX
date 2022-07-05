package br.com.vrsoftware.vrcustomerx.controller;

import br.com.vrsoftware.vrcustomerx.dto.ResponseErrorEntityDTO;
import br.com.vrsoftware.vrcustomerx.service.ExportContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financials")
public class FinancialsController {

    @Autowired
    ExportContactsService exportContactsService;

//    @PostMapping(value = "/{financialId}")
//    public ResponseEntity exportContacts(@PathVariable Integer financialId) throws Exception{
//
//        try {
//            return new ResponseEntity(exportContactsService.execute(customerId), HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity(new ResponseErrorEntityDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
