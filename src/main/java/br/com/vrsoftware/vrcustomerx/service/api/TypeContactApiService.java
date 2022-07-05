package br.com.vrsoftware.vrcustomerx.service.api;

import br.com.vrsoftware.vrcustomerx.config.CustomerxConsts;
import br.com.vrsoftware.vrcustomerx.dto.ClientCustomerxDTO;
import br.com.vrsoftware.vrcustomerx.dto.TypeContactCustomerxDTO;
import br.com.vrsoftware.vrcustomerx.entities.TypeContact;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Service
public class TypeContactApiService {

    public Boolean findByExternalId(Long externalIdClient) throws Exception {
        RestTemplate rstTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + CustomerxConsts.PERSONAL_TOKEN_API);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        URI uri = UriComponentsBuilder.fromUri(new URI(CustomerxConsts.URL_SAND_BOX + CustomerxConsts.PATH_TYPE_CONTACT))
                .queryParam("external_id", String.valueOf(externalIdClient))
                .build()
                .toUri();

        RequestEntity requestEntity = new RequestEntity(headers, HttpMethod.GET, uri);

        ResponseEntity<TypeContactCustomerxDTO[]> response = rstTemplate.exchange(requestEntity, TypeContactCustomerxDTO[].class);

        boolean exists = false;

        if (response.getStatusCode() == HttpStatus.OK) {
            exists = Arrays.stream(response.getBody()).count() > 0;
        }

        return exists;

    }

    public Boolean update(TypeContact typeContact) throws Exception {
        TypeContactCustomerxDTO typeContactCustomerxDTO = new TypeContactCustomerxDTO();
        typeContactCustomerxDTO.setDescription(typeContact.getDescription());
        typeContactCustomerxDTO.setExternal_id(String.valueOf(typeContact.getId()));
        typeContactCustomerxDTO.setStatus(true);


        RestTemplate rstTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + CustomerxConsts.PERSONAL_TOKEN_API);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        URI uri = UriComponentsBuilder.fromUri(new URI(CustomerxConsts.URL_SAND_BOX + CustomerxConsts.PATH_TYPE_CONTACT))
                .queryParam("external_id_contact", typeContact.getId())
                .build()
                .toUri();

        RequestEntity requestEntity = new RequestEntity(typeContactCustomerxDTO, headers, HttpMethod.PUT, uri);
        ResponseEntity<TypeContactCustomerxDTO> response = rstTemplate.exchange(requestEntity, TypeContactCustomerxDTO.class);

        boolean updated = false;

        if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
            updated = response.getBody().getId() > 0;
        }

        return updated;
    }

    public Boolean create(TypeContact typeContact) throws Exception {

        TypeContactCustomerxDTO typeContactCustomerxDTO = new TypeContactCustomerxDTO();
        typeContactCustomerxDTO.setDescription(typeContact.getDescription());
        typeContactCustomerxDTO.setExternal_id(String.valueOf(typeContact.getId()));
        typeContactCustomerxDTO.setStatus(true);


        RestTemplate rstTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + CustomerxConsts.PERSONAL_TOKEN_API);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        URI uri = UriComponentsBuilder.fromUri(new URI(CustomerxConsts.URL_SAND_BOX + CustomerxConsts.PATH_TYPE_CONTACT))
                .build()
                .toUri();

        RequestEntity requestEntity = new RequestEntity(typeContactCustomerxDTO, headers, HttpMethod.POST, uri);
        ResponseEntity<TypeContactCustomerxDTO> response = rstTemplate.exchange(requestEntity, TypeContactCustomerxDTO.class);

        boolean created = false;

        if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
            created = response.getBody().getId() > 0;
        }

        return created;
    }
}
