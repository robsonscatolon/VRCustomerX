package br.com.vrsoftware.vrcustomerx.controller;

import br.com.vrsoftware.vrcustomerx.dto.ClientContactCustomerxDTO;
import br.com.vrsoftware.vrcustomerx.dto.ResponseErrorEntityDTO;
import br.com.vrsoftware.vrcustomerx.service.ExportContactsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerscontacts")
public class CustomerContactsController {

    @Autowired
    ExportContactsService exportContactsService;

    @PostMapping(value = "/{customerId}")
    public ResponseEntity exportContacts(@PathVariable Integer customerId) throws Exception{

        try {
            return new ResponseEntity(exportContactsService.execute(customerId), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new ResponseErrorEntityDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    public List<ClientContactCustomerxDTO> getAll() {
        return exportContactsService.getAll();
    }

    @GetMapping(value = "/{customerId}")
    public List<ClientContactCustomerxDTO> getByCustomer(@PathVariable Integer customerId) {
        return exportContactsService.getByCustomerId(customerId);
    }


}

