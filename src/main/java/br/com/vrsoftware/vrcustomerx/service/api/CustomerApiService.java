package br.com.vrsoftware.vrcustomerx.service.api;

import br.com.vrsoftware.vrcustomerx.config.CustomerxConsts;
import br.com.vrsoftware.vrcustomerx.dto.ClientCustomerxDTO;
import br.com.vrsoftware.vrcustomerx.entities.Customer;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Service
public class CustomerApiService {

    public Boolean findByExternalId(Integer externalIdClient) throws Exception {
        RestTemplate rstTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + CustomerxConsts.PERSONAL_TOKEN_API);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        URI uri = UriComponentsBuilder.fromUri(new URI(CustomerxConsts.URL_SAND_BOX + CustomerxConsts.PATH_CLIENT))
                .queryParam("external_id_client", String.valueOf(externalIdClient))
                .build()
                .toUri();

        RequestEntity requestEntity = new RequestEntity(headers, HttpMethod.GET, uri);
        ResponseEntity<ClientCustomerxDTO[]> response = rstTemplate.exchange(requestEntity, ClientCustomerxDTO[].class);

        boolean exists = false;

        if (response.getStatusCode() == HttpStatus.OK) {
            exists = Arrays.stream(response.getBody()).count() > 0;
        }

        return exists;

    }

    public Boolean update(Customer customer) throws Exception{
        ClientCustomerxDTO clientCustomerxDTO = new ClientCustomerxDTO();
        clientCustomerxDTO.setEmail(customer.getEmail());
        clientCustomerxDTO.setCep(String.valueOf(customer.getCep()));
        clientCustomerxDTO.setNumber(customer.getNumero());
        clientCustomerxDTO.setCnpj_cpf(String.valueOf(customer.getCnpj()));
        clientCustomerxDTO.setCity(customer.getMunicipio().getDescricao());
        clientCustomerxDTO.setState(customer.getEstado().getDescription());
        clientCustomerxDTO.setDate_register(customer.getDataCadastro());
        clientCustomerxDTO.setCountry("BRASIL");
        clientCustomerxDTO.setCompany_name(customer.getRazaosocial());
        clientCustomerxDTO.setTrading_name(customer.getNomeFantasia());
        clientCustomerxDTO.setIe_rg(customer.getInscricaoEstadual());
        clientCustomerxDTO.setStreet(customer.getEndereco());
        clientCustomerxDTO.setDistrict(customer.getBairro());

        RestTemplate rstTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + CustomerxConsts.PERSONAL_TOKEN_API);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        URI uri = UriComponentsBuilder.fromUri(new URI(CustomerxConsts.URL_SAND_BOX + CustomerxConsts.PATH_CLIENT))
                .queryParam("external_id_client", customer.getId())
                .build()
                .toUri();

        RequestEntity requestEntity = new RequestEntity(clientCustomerxDTO, headers, HttpMethod.PUT, uri);
        ResponseEntity<ClientCustomerxDTO> response = rstTemplate.exchange(requestEntity, ClientCustomerxDTO.class);

        boolean created = false;


        if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
            created = response.getBody().getId() > 0;
        }

        return created;
    }

    public Boolean create(Customer customer) throws Exception {

        ClientCustomerxDTO clientCustomerxDTO = new ClientCustomerxDTO();
        clientCustomerxDTO.setExternal_id_client(String.valueOf(customer.getId()));
        clientCustomerxDTO.setEmail(customer.getEmail());
        clientCustomerxDTO.setCep(String.valueOf(customer.getCep()));
        clientCustomerxDTO.setNumber(customer.getNumero());
        clientCustomerxDTO.setCnpj_cpf(String.valueOf(customer.getCnpj()));
        clientCustomerxDTO.setCity(customer.getMunicipio().getDescricao());
        clientCustomerxDTO.setState(customer.getEstado().getDescription());
        clientCustomerxDTO.setDate_register(customer.getDataCadastro());
        clientCustomerxDTO.setCountry("BRASIL");
        clientCustomerxDTO.setCompany_name(customer.getRazaosocial());
        clientCustomerxDTO.setTrading_name(customer.getNomeFantasia());
        clientCustomerxDTO.setIe_rg(customer.getInscricaoEstadual());
        clientCustomerxDTO.setStreet(customer.getEndereco());
        clientCustomerxDTO.setDistrict(customer.getBairro());

        RestTemplate rstTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + CustomerxConsts.PERSONAL_TOKEN_API);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        URI uri = UriComponentsBuilder.fromUri(new URI(CustomerxConsts.URL_SAND_BOX + CustomerxConsts.PATH_CLIENT))
                .build()
                .toUri();

        RequestEntity requestEntity = new RequestEntity(clientCustomerxDTO, headers, HttpMethod.POST, uri);
        ResponseEntity<ClientCustomerxDTO> response = rstTemplate.exchange(requestEntity, ClientCustomerxDTO.class);

        boolean created = false;


        if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
            created = response.getBody().getId() > 0;
        }

        return created;


    }

}
