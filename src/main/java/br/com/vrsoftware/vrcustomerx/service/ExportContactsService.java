package br.com.vrsoftware.vrcustomerx.service;

import br.com.vrsoftware.vrcustomerx.config.CustomerxConsts;
import br.com.vrsoftware.vrcustomerx.dto.ClientContactCustomerxDTO;
import br.com.vrsoftware.vrcustomerx.dto.ClientContactPhoneCustomerxDTO;
import br.com.vrsoftware.vrcustomerx.entities.CustomerContact;
import br.com.vrsoftware.vrcustomerx.repository.ICustomerContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExportContactsService {

    @Autowired
    ICustomerContactRepository customerContactRepository;

    public List<ClientContactCustomerxDTO> execute(Integer customerId) throws Exception {
        List<ClientContactCustomerxDTO> contacts = getByCustomerId(customerId);

        RestTemplate rstTemplate = new RestTemplate();

        for (ClientContactCustomerxDTO contact : contacts) {
            contact = send(contact);
        }

        return contacts;

    }

    private ClientContactCustomerxDTO send(ClientContactCustomerxDTO contact) throws Exception {
        RestTemplate rstTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + CustomerxConsts.PERSONAL_TOKEN_API);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        URI uri = UriComponentsBuilder.fromUri(new URI(CustomerxConsts.URL_SAND_BOX + CustomerxConsts.PATH_CONTACT))
                .build()
                .toUri();

        RequestEntity requestEntity = new RequestEntity(contact, headers, HttpMethod.POST, uri);

        ClientContactCustomerxDTO newContact = null;

        try {
            ResponseEntity<ClientContactCustomerxDTO> response = rstTemplate.exchange(requestEntity, ClientContactCustomerxDTO.class);

            if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
                newContact = response.getBody();
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            throw new Exception("An error occurred when trying to send "
                    + contact.getName() + " of client " + contact.getExternal_id_client()
                    + (!ex.getMessage().isEmpty() ? ". Error:" + ex.getMessage() : "."));
        }

        return newContact;
    }

    public List<ClientContactCustomerxDTO> getByCustomerId(Integer customerId) {
        List<CustomerContact> customersContacts = customerContactRepository.findAllContactsByClientId(customerId);

        List<ClientContactCustomerxDTO> contacts = customersContacts.stream().map(customerContact -> {
            return new ClientContactCustomerxDTO(customerContact.getEmail(),
                    customerContact.getNome(),
                    customerContact.getTypeContact().getId(),
                    String.valueOf(customerContact.getId_cliente()),
                    getPhones(customerContact.getCelular(), customerContact.getTelefone()));
        }).collect(Collectors.toList());

        return contacts;
    }

    public List<ClientContactCustomerxDTO> getAll() {
        List<CustomerContact> customersContacts = customerContactRepository.findAll();

        List<ClientContactCustomerxDTO> contacts = customersContacts.stream().map(customerContact -> {
            return new ClientContactCustomerxDTO(customerContact.getEmail(),
                    customerContact.getNome(),
                    customerContact.getTypeContact().getId(),
                    String.valueOf(customerContact.getId_cliente()),
                    getPhones(customerContact.getCelular(), customerContact.getTelefone()));
        }).collect(Collectors.toList());

        return contacts;

    }

    private List<ClientContactPhoneCustomerxDTO> getPhones(String celphone, String phone){
        List<ClientContactPhoneCustomerxDTO> phones = new ArrayList<>();

        if(celphone != null && !celphone.isBlank() && celphone.matches(".*[1-9].*")){
            phones.add(new ClientContactPhoneCustomerxDTO(celphone, true));
        }

        if(phone != null && !phone.isBlank() && phone.matches(".*[1-9].*")){
            phones.add(new ClientContactPhoneCustomerxDTO(phone, false));
        }

        return phones.isEmpty() ? null : phones;
    }


}
