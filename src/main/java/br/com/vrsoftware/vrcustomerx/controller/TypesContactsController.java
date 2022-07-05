package br.com.vrsoftware.vrcustomerx.controller;

import br.com.vrsoftware.vrcustomerx.entities.TypeContact;
import br.com.vrsoftware.vrcustomerx.service.ExportTypeContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typescontacts")
public class TypesContactsController {

    @Autowired
    ExportTypeContactService exportTypeContactService;


    @GetMapping()
    public void exists() throws Exception{
        exportTypeContactService.execute();
    }
}
