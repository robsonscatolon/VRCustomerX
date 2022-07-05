package br.com.vrsoftware.vrcustomerx.service;

import br.com.vrsoftware.vrcustomerx.entities.TypeContact;
import br.com.vrsoftware.vrcustomerx.repository.ITypeContactRepository;
import br.com.vrsoftware.vrcustomerx.service.api.TypeContactApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportTypeContactService {

    @Autowired
    ITypeContactRepository typeContactRepository;

    @Autowired
    TypeContactApiService typeContactApiService;


    public void execute() throws Exception {

        List<TypeContact> typesContact = typeContactRepository.findAll();

        for(TypeContact typeContact: typesContact){
            Boolean exists = typeContactApiService.findByExternalId(typeContact.getId());

            if(exists){
                typeContactApiService.update(typeContact);
            }else {
                typeContactApiService.create(typeContact);
            }
        }

    }
}
