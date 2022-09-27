package com.rtisas.facade.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rtisas.facade.config.ProxyFacade;
import com.rtisas.facade.entity.Services;
import com.rtisas.facade.entity.UserLogin;
import com.rtisas.facade.response.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/crew-leader")
public class CrewLeaderController {

    private MainController controller;

    @Value("${SERVICAD_AWS}")
    private String PATH_SERVICAD;

    @Value("${LOGIN}")
    private String LOGIN;

    @Value("${SERVICES}")
    private String SERVICES;

    @Value("${ALL}")
    private String ALL;

    @Value("${UPDATE}")
    private String UPDATE;

    @Value("${TIME}")
    private String TIME;

    @Value("${TIMEBYNAME}")
    private String TIMEBYNAME;

    @Value("${AWSS3}")
    private String AWSS3;

    @Value("${CONTACT}")
    private String CONTACT;

    @Value("${FILESERVICES}")
    private String FILESERVICES;

    @Value("${FILESERVICESUPDATE}")
    private String FILESERVICESUPDATE;

    @Value("${FILESERVICESDELETE}")
    private String FILESERVICESDELETE;

    public CrewLeaderController() {
        this.controller = new MainController();
    }

    @RequestMapping({"/"})
    public ResponseEntity<Object> mainConnectionWithBackend(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return this.controller.getObjectResponseEntity(null, headers, PATH_SERVICAD, HttpMethod.GET, String.class);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginSystem(@RequestBody UserLogin user) throws JsonProcessingException {
        return this.controller.getObjectResponseEntity(user, null, PATH_SERVICAD + LOGIN, HttpMethod.POST, TokenResponse.class);
    }

    @GetMapping("/all_services")
    public ResponseEntity<Object> getAllServices(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return this.controller.getObjectResponseEntity(null, headers, PATH_SERVICAD+SERVICES+ALL, HttpMethod.GET, Object.class);
    }

    @PutMapping("/put-service/{id}")
    public ResponseEntity<Object> updateService(@PathVariable Long id, @RequestBody Services services, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return this.controller.getObjectResponseEntity(services, headers, PATH_SERVICAD+SERVICES+UPDATE+id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-time/name/{name}")
    public ResponseEntity<Object> getTimeByName(@PathVariable String name) throws JsonProcessingException {
        return this.controller.getObjectResponseEntity(null, null,PATH_SERVICAD+TIME+TIMEBYNAME+name, HttpMethod.GET, Object.class);
    }

    //CONTACTS
    @GetMapping("/get-contact/all")
    public ResponseEntity<Object> getAllContact(@RequestHeader HttpHeaders headers, @RequestParam(value = "number")String number) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("number", number);

        String uriParams = "?number={number}";

        if (headers != null){
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            ProxyFacade service = new ProxyFacade(new RestTemplate());
            return service.postServiceAPI(PATH_SERVICAD+CONTACT+ALL+uriParams, HttpMethod.GET, requestEntity, Object.class, params);
        }

        return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
    }

    //FILE S3 SERVICES CUSTOMER
    @PostMapping("/post-service/customer")
    public ResponseEntity<Object> UploadingServicesCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file") MultipartFile file, @RequestPart(value = "user")String user, @RequestPart(value = "orderservice")String orderService){
        String path = PATH_SERVICAD+AWSS3+FILESERVICES;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);
        requestEntity.add("orderservice", orderService);

        return MainController.createFileS3(headers, requestEntity, path);
    }

    @PostMapping("/post-filesservice/customer")
    public ResponseEntity<Object> UploadingFilesServicesCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file") List<MultipartFile> files, @RequestPart(value = "user")String user, @RequestPart(value = "orderservice")String orderService){
        for (MultipartFile file: files) {
            UploadingServicesCustomer(headers, file, user, orderService);
        }
        return ResponseEntity.ok().body("Archivos cargados con éxito");
    }

    @PutMapping("/put-service/customer/{idFile}")
    public ResponseEntity<Object> UpdatingServicesCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user, @RequestPart(value = "key") String key, @RequestPart(value = "orderservice")String orderService, @PathVariable Long idFile){
        String path = PATH_SERVICAD+AWSS3+FILESERVICESUPDATE+idFile;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);
        requestEntity.add("key", key);
        requestEntity.add("orderservice", orderService);

        return MainController.updateFileS3(headers, requestEntity, path);
    }

    @PostMapping("/delete-service/customer")
    public ResponseEntity<Object> DeleteServicesCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "key")String key){
        String path = PATH_SERVICAD+AWSS3+FILESERVICESDELETE;
        LinkedMultiValueMap<String,Object> requestEntityGetObject = new LinkedMultiValueMap<>();

        requestEntityGetObject.add("key", key);

        return MainController.deleteFileS3(headers, requestEntityGetObject, path);
    }
}