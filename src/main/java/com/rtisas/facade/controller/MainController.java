package com.rtisas.facade.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtisas.facade.config.ProxyFacade;
import com.rtisas.facade.entity.*;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/web")
@Component
public class MainController {

    @Value("${SERVICAD_AWS}")
    private String PATH_SERVICAD;

    @Value("${ALL}")
    private String ALL;

    @Value("${CREATE}")
    private String CREATE;

    @Value("${BITACORA}")
    private String BITACORA;

    @Value("${DELETE}")
    private String DELETE;

    @Value("${UPDATE}")
    private String UPDATE;

    @Value("${AUTHORIZATION}")
    private String AUTHORIZATION;

    @Value("${AWSS3}")
    private String AWSS3;

    @Value("${BRANCHOFFICE}")
    private String BRANCHOFFICE;

    @Value("${BYNAME}")
    private String BYNAME;

    @Value("${CHANGEPASSWORD}")
    private String CHANGEPASSWORD;

    @Value("${CITY}")
    private String CITY;

    @Value("${CODEPASSWORD}")
    private String CODEPASSWORD;

    @Value("${COMMENT}")
    private String COMMENT;

    @Value("${CONTACT}")
    private String CONTACT;

    @Value("${COURSE}")
    private String COURSE;

    @Value("${COURSESEMPLOYEE}")
    private String COURSESEMPLOYEE;

    @Value("${COURSEEMPLOYEE}")
    private String COURSEEMPLOYEE;

    @Value("${COURSEEMPLOYEEUPDATE}")
    private String COURSEEMPLOYEEUPDATE;

    @Value("${COURSEEMPLOYEEDELETE}")
    private String COURSEEMPLOYEEDELETE;

    @Value("${CUSTOMERS}")
    private String CUSTOMERS;

    @Value("${DELIVERYCERTIFICATE}")
    private String DELIVERYCERTIFICATE;

    @Value("${EMPLOYEES}")
    private String EMPLOYEES;

    @Value("${EQUIPMENT}")
    private String EQUIPMENT;

    @Value("${EQUIPMENTCUSTOMER}")
    private String EQUIPMENTCUSTOMER;

    @Value("${EQUIPMENTCUSTOMERUPDATE}")
    private String EQUIPMENTCUSTOMERUPDATE;

    @Value("${EQUIPMENTCUSTOMERDELETE}")
    private String EQUIPMENTCUSTOMERDELETE;

    @Value("${EQUIPMENTFILE}")
    private String EQUIPMENTFILE;

    @Value("${FILE_CATEGORY}")
    private String FILE_CATEGORY;

    @Value("${FILE_TYPE}")
    private String FILE_TYPE;

    @Value("${FILES}")
    private String FILES;

    @Value("${FILESERVICES}")
    private String FILESERVICES;

    @Value("${FILESERVICESUPDATE}")
    private String FILESERVICESUPDATE;

    @Value("${FILESERVICESDELETE}")
    private String FILESERVICESDELETE;

    @Value("${FILTERS}")
    private String FILTERS;

    @Value("${FILESDC}")
    private String FILESDC;

    @Value("${GENERATE}")
    private String GENERATE;

    @Value("${EPS}")
    private String EPS;

    @Value("${IDENTIFICATION_TYPE}")
    private String IDENTIFICATION_TYPE;

    @Value("${IDFILE}")
    private String IDFILE;

    @Value("${JOBTITLE}")
    private String JOBTITLE;

    @Value("${LOGIN}")
    private String LOGIN;

    @Value("${MENU}")
    private String MENU;

    @Value("${PERMANENTLY}")
    private String PERMANENTLY;

    @Value("${PICTUREEMPLOYEE}")
    private String PICTUREEMPLOYEE;

    @Value("${PICTUREEMPLOYEEUPDATE}")
    private String PICTUREEMPLOYEEUPDATE;

    @Value("${PICTUREEMPLOYEEDELETE}")
    private String PICTUREEMPLOYEEDELETE;

    @Value("${PICTURECUSTOMER}")
    private String PICTURECUSTOMER;

    @Value("${PICTURECUSTOMERUPDATE}")
    private String PICTURECUSTOMERUPDATE;

    @Value("${PICTURECUSTOMERDELETE}")
    private String PICTURECUSTOMERDELETE;

    @Value("${REPORT}")
    private String REPORT;

    @Value("${ROLE}")
    private String ROLES;

    @Value("${SDC}")
    private String SDC;

    @Value("${SENDLIST}")
    private String SENDLIST;

    @Value("${SERVICES}")
    private String SERVICES;

    @Value("${SERVICEBYUSERORCUSTOMER}")
    private String SERVICEBYUSERORCUSTOMER;

    @Value("${GET-STATUS}")
    private String GETSTATUS;

    @Value("${PROGRAMMED}")
    private String PROGRAMMED;

    @Value("${ASSIGNED}")
    private String ASIGNED;

    @Value("${EXECUTION}")
    private String EXECUTION;

    @Value("${COMPLETED}")
    private String COMPLETED;

    @Value("${SIGNAGE}")
    private String SIGNAGE;

    @Value("${STATUS}")
    private String STATUS;

    @Value("${STATUSSERVICE}")
    private String STATUSSERVICE;

    @Value("${TIME}")
    private String TIME;

    @Value("${TIMEBYNAME}")
    private String TIMEBYNAME;

    @Value("${TYPESERVICE}")
    private String TYPESERVICE;

    @Value("${USERS}")
    private String USERS;

    @Value("${USERSCUSTOMER}")
    private String USERSCUSTOMER;

    @Value("${USERSROLE}")
    private String USERSROLE;

    @GetMapping({"/"})
    public ResponseEntity<Object> mainConnectionWithBackend(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD, HttpMethod.GET, String.class);
    }

    //LOGIN
    @PostMapping("/login")
    public ResponseEntity<Object> loginSystem(@RequestBody UserLogin user) throws JsonProcessingException {
        return getObjectResponseEntity(user, null, PATH_SERVICAD + LOGIN, HttpMethod.POST, Object.class);
    }

    //ID_TYPES
    @GetMapping("/get-id-types/all")
    public ResponseEntity<Object> getAllIdTypes(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + IDENTIFICATION_TYPE + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-id-type")
    public ResponseEntity<Object> createIdType(@RequestBody IdentificationType idType, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(idType, headers, PATH_SERVICAD + IDENTIFICATION_TYPE + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-id-type/{id}")
    public ResponseEntity<Object> updateIdType(@PathVariable Long id, @RequestBody IdentificationType idType, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(idType, headers, PATH_SERVICAD + IDENTIFICATION_TYPE + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-id-type/{id}")
    public ResponseEntity<Object> getOneIdType(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + IDENTIFICATION_TYPE + id, HttpMethod.GET, Object.class);
    }

    //CUSTOMERS
    @GetMapping("/get-customers/all")
    public ResponseEntity<Object> getAllCustomers(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + CUSTOMERS + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-customer")
    public ResponseEntity<Object> createCustomer(@RequestBody CreateCustomer customer, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(customer, headers, PATH_SERVICAD + CUSTOMERS + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable Long id, @RequestBody Customer customer, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(customer, headers, PATH_SERVICAD + CUSTOMERS + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-customer/{id}")
    public ResponseEntity<Object> getOneCustomer(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + CUSTOMERS + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + CUSTOMERS + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //FILES
    @GetMapping("/get-files/all")
    public ResponseEntity<Object> getAllFiles(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + FILES + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-file")
    public ResponseEntity<Object> createFile(@RequestBody File file, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(file, headers, PATH_SERVICAD + FILES + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-file/{id}")
    public ResponseEntity<Object> updateFile(@PathVariable Long id, @RequestBody File file, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(file, headers, PATH_SERVICAD + FILES + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-file/{id}")
    public ResponseEntity<Object> getOneFile(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + FILES + id, HttpMethod.GET, Object.class);
    }

    //FILE_CATEGORY
    @GetMapping("/get-file-categories/all")
    public ResponseEntity<Object> getAllFileCategories(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + FILE_CATEGORY + ALL, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-file-category/{id}")
    public ResponseEntity<Object> getOneFileCategory(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + FILE_CATEGORY + id, HttpMethod.GET, Object.class);
    }

    //FILE_TYPES
    @GetMapping("/get-file-types/all")
    public ResponseEntity<Object> getAllFileTypes(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + FILE_TYPE + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-file-type")
    public ResponseEntity<Object> createFileType(@RequestBody FileType fileType, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(fileType, headers, PATH_SERVICAD + FILE_TYPE + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-file-type/{id}")
    public ResponseEntity<Object> updateFileType(@PathVariable Long id, @RequestBody FileType fileType, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(fileType, headers, PATH_SERVICAD + FILE_TYPE + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-file-type/{id}")
    public ResponseEntity<Object> getOneFileType(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + FILE_TYPE + id, HttpMethod.GET, Object.class);
    }

    //EPS
    @GetMapping("/get-eps/all")
    public ResponseEntity<Object> getAllEps(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EPS + ALL, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-eps/{id}")
    public ResponseEntity<Object> getOneEps(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EPS + id, HttpMethod.GET, Object.class);
    }

    //EMPLOYEES
    @GetMapping("/get-employees/all")
    public ResponseEntity<Object> getAllEmployees(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EMPLOYEES + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-employee")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(employee, headers, PATH_SERVICAD + EMPLOYEES + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-employee/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(employee, headers, PATH_SERVICAD + EMPLOYEES + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-employee/{id}")
    public ResponseEntity<Object> getOneEmployee(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EMPLOYEES + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-employeerole/{id}")
    public ResponseEntity<Object> getEmployeeRole(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EMPLOYEES + ROLES + id, HttpMethod.GET, Object.class);
    }

    //ROLE
    @GetMapping("/role/all")
    public ResponseEntity<Object> getAllRoles(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + ROLES + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-role")
    public ResponseEntity<Object> createRole(@RequestBody Role rol, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(rol, headers, PATH_SERVICAD + ROLES + CREATE, HttpMethod.POST, Role.class);
    }

    @PutMapping("/put-role/{id}")
    public ResponseEntity<Object> updateRole(@PathVariable Long id, @RequestBody Role rol, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(rol, headers, PATH_SERVICAD + ROLES + UPDATE + id, HttpMethod.PUT, Void.class);
    }

    @GetMapping("/get-role/{id}")
    public ResponseEntity<Object> updateRole(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + ROLES + id, HttpMethod.GET, Role.class);
    }

    //EQUIPMENT
    @GetMapping("/get-equipment/all")
    public ResponseEntity<Object> getAllEquipment(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EQUIPMENT + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-equipment")
    public ResponseEntity<Object> createEquipment(@RequestBody Equipment equipment, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(equipment, headers, PATH_SERVICAD + EQUIPMENT + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-equipment/{id}")
    public ResponseEntity<Object> updateEquipment(@PathVariable Long id, @RequestBody Equipment equipment, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(equipment, headers, PATH_SERVICAD + EQUIPMENT + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-equipment/{id}")
    public ResponseEntity<Object> equipmentById(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EQUIPMENT + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-equipment/{id}")
    public ResponseEntity<Object> deleteEquipment(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EQUIPMENT + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //SERVICES
    @GetMapping("/get-services/all")
    public ResponseEntity<Object> getAllServices(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-service")
    public ResponseEntity<Object> createService(@RequestBody Services services, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(services, headers, PATH_SERVICAD + SERVICES + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-service/{id}")
    public ResponseEntity<Object> updateService(@PathVariable Long id, @RequestBody Services services, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(services, headers, PATH_SERVICAD + SERVICES + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-service/{id}")
    public ResponseEntity<Object> getOneService(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-servicestatus/{id}")
    public ResponseEntity<Object> getAllServiceStatus(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + STATUS + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-servicesallbyuc/{id}")
    public ResponseEntity<Object> getAllByUserOrCustomer(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + SERVICEBYUSERORCUSTOMER + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-service/programmed/{id}")
    public ResponseEntity<Object> getAllServiceByStatusProgrammedCustomer(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + GETSTATUS + PROGRAMMED + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-service/asigned/{id}")
    public ResponseEntity<Object> getAllServiceByStatusAsigned(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + GETSTATUS + ASIGNED + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-service/execution/{id}")
    public ResponseEntity<Object> getAllServiceByStatusExecution(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + GETSTATUS + EXECUTION + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-service/completed/{id}")
    public ResponseEntity<Object> getAllServiceByStatusCompleted(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + GETSTATUS + COMPLETED + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-service/{id}")
    public ResponseEntity<Object> deleteService(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    @DeleteMapping("/delete-service/permanently/{id}")
    public ResponseEntity<Object> deleteServicePermanently(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SERVICES + DELETE + PERMANENTLY + id, HttpMethod.DELETE, Object.class);
    }

    //BRANCHOFFICE
    @GetMapping("/get-branchoffice/all")
    public ResponseEntity<Object> getAllBranchOffice(@RequestHeader HttpHeaders headers, @RequestParam(value = "number") String number) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("number", number);

        String uriParams = "?number={number}";

        if (headers != null) {
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            ProxyFacade service = new ProxyFacade(new RestTemplate());
            return service.postServiceAPI(PATH_SERVICAD + BRANCHOFFICE + ALL + uriParams, HttpMethod.GET, requestEntity, Object.class, params);
        }

        return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
    }


    @PostMapping("/post-branchoffice")
    public ResponseEntity<Object> createBranchOffice(@RequestBody BranchOffice branchOffice, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(branchOffice, headers, PATH_SERVICAD + BRANCHOFFICE + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-branchoffice/{id}")
    public ResponseEntity<Object> updateBranchOffice(@PathVariable Long id, @RequestBody BranchOffice branchOffice, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(branchOffice, headers, PATH_SERVICAD + BRANCHOFFICE + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-branchoffice/{id}")
    public ResponseEntity<Object> getOneBranchOffice(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + BRANCHOFFICE + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-branchoffice/{id}")
    public ResponseEntity<Object> deleteBranchOffice(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + BRANCHOFFICE + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //CITY
    @GetMapping("/get-city/all")
    public ResponseEntity<Object> getAllCity(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + CITY + ALL, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-city/{id}")
    public ResponseEntity<Object> getOneCity(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + CITY + id, HttpMethod.GET, Object.class);
    }

    //JOBTITLE
    @PostMapping("/jobtitle/create")
    public ResponseEntity<Object> createJobTitle(@RequestBody JobTitle request, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(request, headers, PATH_SERVICAD + JOBTITLE + CREATE, HttpMethod.POST, Object.class);
    }

    @GetMapping("/get-jobtitle/all")
    public ResponseEntity<Object> getAllJobTitle(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + JOBTITLE + ALL, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-jobtitle/{id}")
    public ResponseEntity<Object> getOneJobTitle(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + JOBTITLE + id, HttpMethod.GET, Object.class);
    }

    //STATUSSERVICE
    @GetMapping("/get-statusservice/all")
    public ResponseEntity<Object> getAllStatusService(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + STATUSSERVICE + ALL, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-statusservice/{id}")
    public ResponseEntity<Object> getOneStatusService(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + STATUSSERVICE + id, HttpMethod.GET, Object.class);
    }

    //TYPESERVICE
    @GetMapping("/get-typeservice/all")
    public ResponseEntity<Object> getAllTypeServices(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + TYPESERVICE + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-typeservice")
    public ResponseEntity<Object> createTypeServices(@RequestBody TypeService typeService, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(typeService, headers, PATH_SERVICAD + TYPESERVICE + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-typeservice/{id}")
    public ResponseEntity<Object> updateTypeServices(@PathVariable Long id, @RequestBody TypeService typeService, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(typeService, headers, PATH_SERVICAD + TYPESERVICE + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-typeservice/{id}")
    public ResponseEntity<Object> getOneTypeServices(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + TYPESERVICE + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-typeservice/{id}")
    public ResponseEntity<Object> deleteTypeServices(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + TYPESERVICE + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //USER
    @GetMapping("/get-users/all")
    public ResponseEntity<Object> getAllUsers(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + USERS + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-users")
    public ResponseEntity<Object> createUsers(@RequestBody User user, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(user, headers, PATH_SERVICAD + USERS + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-users/{id}")
    public ResponseEntity<Object> updateUsers(@PathVariable Long id, @RequestBody User user, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(user, headers, PATH_SERVICAD + USERS + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-users/{id}")
    public ResponseEntity<Object> getOneUsers(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + USERS + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-userscustomer/{id}")
    public ResponseEntity<Object> getOneUsersCustomer(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + USERS + USERSCUSTOMER + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-usersrole/{id}")
    public ResponseEntity<Object> getOneUsersRole(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + USERS + USERSROLE + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-users/{id}")
    public ResponseEntity<Object> deleteUsers(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + USERS + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //TIME SETTING
    @PutMapping("/put-time/{id}")
    public ResponseEntity<Object> updateTime(@PathVariable Long id, @RequestBody Time time, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(time, headers, PATH_SERVICAD + TIME + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-time/{id}")
    public ResponseEntity<Object> getTimeById(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + TIME + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-time/name/{name}")
    public ResponseEntity<Object> getTimeByName(@PathVariable String name) throws JsonProcessingException {
        return getObjectResponseEntity(null, null, PATH_SERVICAD + TIME + TIMEBYNAME + name, HttpMethod.GET, Object.class);
    }

    //CONTACTS
    @GetMapping("/get-contact/all")
    public ResponseEntity<Object> getAllContact(@RequestHeader HttpHeaders headers, @RequestParam(value = "number") String number) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("number", number);

        String uriParams = "?number={number}";

        if (headers != null) {
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            ProxyFacade service = new ProxyFacade(new RestTemplate());
            return service.postServiceAPI(PATH_SERVICAD + CONTACT + ALL + uriParams, HttpMethod.GET, requestEntity, Object.class, params);
        }

        return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
    }

    @PostMapping("/post-contact")
    public ResponseEntity<Object> createContact(@RequestBody Contact contact, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(contact, headers, PATH_SERVICAD + CONTACT + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-contact/{id}")
    public ResponseEntity<Object> updateContact(@PathVariable Long id, @RequestBody Contact contact, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(contact, headers, PATH_SERVICAD + CONTACT + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-contact/{id}")
    public ResponseEntity<Object> getOneContact(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + CONTACT + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-contact/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + CONTACT + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //COURSES
    @GetMapping("/get-courses/name")
    public ResponseEntity<Object> getCoursesByName(@RequestHeader HttpHeaders headers, @RequestParam(value = "number") String name) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);

        String uriParams = "?name={name}";

        if (headers != null) {
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            ProxyFacade service = new ProxyFacade(new RestTemplate());
            return service.postServiceAPI(PATH_SERVICAD + COURSE + BYNAME + uriParams, HttpMethod.GET, requestEntity, Object.class, params);
        }

        return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
    }

    @PostMapping("/post-course")
    public ResponseEntity<Object> createCourse(@RequestBody Course course, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(course, headers, PATH_SERVICAD + COURSE + CREATE, HttpMethod.POST, Object.class);
    }

    @GetMapping("/get-courses/all")
    public ResponseEntity<Object> getCoursesAll(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + COURSE + ALL, HttpMethod.GET, Object.class);
    }

    @PutMapping("/put-course/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable Long id, @RequestBody Course course, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(course, headers, PATH_SERVICAD + CONTACT + COURSE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-course/{id}")
    public ResponseEntity<Object> getOneCourse(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + COURSE + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-course/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + COURSE + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //COURSES EMPLOYEE
    @GetMapping("/get-coursesemployee/all")
    public ResponseEntity<Object> getCoursesByNumberIdentification(@RequestHeader HttpHeaders headers, @RequestParam(value = "name") String number) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("number", number);

        String uriParams = "?number={number}";

        if (headers != null) {
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            ProxyFacade service = new ProxyFacade(new RestTemplate());
            return service.postServiceAPI(PATH_SERVICAD + COURSESEMPLOYEE + ALL + uriParams, HttpMethod.GET, requestEntity, Object.class, params);
        }

        return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
    }

    @PostMapping("/post-courseemployee")
    public ResponseEntity<Object> createCourseEmployee(@RequestBody CourseEmployee course, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(course, headers, PATH_SERVICAD + COURSESEMPLOYEE + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-courseemployee/{id}")
    public ResponseEntity<Object> updateCourseEmployee(@PathVariable Long id, @RequestBody CourseEmployee course, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(course, headers, PATH_SERVICAD + COURSESEMPLOYEE + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-courseemployee/{id}")
    public ResponseEntity<Object> getOneCourseEmployee(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + COURSESEMPLOYEE + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-courseemployee/{id}")
    public ResponseEntity<Object> deleteCourseEmployee(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + COURSESEMPLOYEE + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //SIGNAGES
    @GetMapping("/get-signages/all")
    public ResponseEntity<Object> getAllSignages(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SIGNAGE + ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-signage")
    public ResponseEntity<Object> createSignage(@RequestBody Signage signage, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(signage, headers, PATH_SERVICAD + SIGNAGE + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-signage/{id}")
    public ResponseEntity<Object> updateSignage(@PathVariable Long id, @RequestBody Signage signage, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(signage, headers, PATH_SERVICAD + SIGNAGE + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-signage/{id}")
    public ResponseEntity<Object> SignageById(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SIGNAGE + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-signage/{id}")
    public ResponseEntity<Object> deleteSignage(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + SIGNAGE + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //EQUIPMENT FILES
    @GetMapping("/get-equipmentfiles/all")
    public ResponseEntity<Object> getAllEquipmentFiles(@RequestHeader HttpHeaders headers, @RequestParam(value = "serial") String serial) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("serial", serial);

        String uriParams = "?serial={serial}";

        if (headers != null) {
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            ProxyFacade service = new ProxyFacade(new RestTemplate());
            return service.postServiceAPI(PATH_SERVICAD + EQUIPMENTFILE + ALL + uriParams, HttpMethod.GET, requestEntity, Object.class, params);
        }

        return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
    }

    @PostMapping("/post-equipmentfile")
    public ResponseEntity<Object> createEquipmentFile(@RequestBody EquipmentFile equipmentFile, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(equipmentFile, headers, PATH_SERVICAD + EQUIPMENTFILE + CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-equipmentfile/{id}")
    public ResponseEntity<Object> updateEquipmentFile(@PathVariable Long id, @RequestBody EquipmentFile equipmentFile, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(equipmentFile, headers, PATH_SERVICAD + EQUIPMENTFILE + UPDATE + id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-equipmentfile/idfile/{id}")
    public ResponseEntity<Object> getOneEquipmentFileByIdFile(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EQUIPMENTFILE + IDFILE + id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-equipmentfile/{id}")
    public ResponseEntity<Object> getOneEquipmentFile(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EQUIPMENTFILE + id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping("/delete-equipmentfile/{id}")
    public ResponseEntity<Object> deleteEquipmentFile(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD + EQUIPMENTFILE + DELETE + id, HttpMethod.DELETE, Object.class);
    }

    //COMMENTS
    @GetMapping("/get-comment/all/")
    public ResponseEntity<Object> getAllComments(@RequestHeader HttpHeaders headers, @RequestParam(value = "service") Long service, @RequestParam(value = "type") Long type) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("service", service);
        params.put("type", type);
        String uriParamSer = ("?service={service}");
        String uriParamTyp = ("&type={type}");

        if (headers != null) {
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            ProxyFacade proxy = new ProxyFacade(new RestTemplate());
            return proxy.postServiceAPI(PATH_SERVICAD + COMMENT + ALL+"/"+uriParamSer + uriParamTyp , HttpMethod.GET, requestEntity, Object.class, params);
        }
        return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
    }
    @PostMapping("/post-comment")
    public ResponseEntity<Object> createComment(@RequestBody Comment comment, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(comment, headers, PATH_SERVICAD+COMMENT+CREATE, HttpMethod.POST, Object.class);
    }

    @PostMapping("/post-bitacora")
    public ResponseEntity<Object> createBitacora(@RequestBody Comment comment, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(comment, headers, PATH_SERVICAD+COMMENT+BITACORA+CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-comment/{id}")
    public ResponseEntity<Object> updateComment(@PathVariable Long id, @RequestBody Comment comment, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(comment, headers, PATH_SERVICAD+COMMENT+UPDATE+id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-comment/{id}")
    public ResponseEntity<Object> CommentById(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+COMMENT+id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping ("/delete-comment/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+COMMENT+DELETE+id, HttpMethod.DELETE, Object.class);
    }

    //DELIVERY CERTIFICATE
    @GetMapping("/get-delcert/service/{id}")
    public ResponseEntity<Object> getDelCertByService(@RequestHeader HttpHeaders headers, @PathVariable Long id) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+DELIVERYCERTIFICATE+SERVICES+id, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-delcert")
    public ResponseEntity<Object> createDelCert(@RequestBody DeliveryCertificate deliveryCertificate, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(deliveryCertificate, headers, PATH_SERVICAD+DELIVERYCERTIFICATE+CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-delcert/{id}")
    public ResponseEntity<Object> updateDelCert(@PathVariable Long id, @RequestBody DeliveryCertificate deliveryCertificate, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(deliveryCertificate, headers, PATH_SERVICAD+DELIVERYCERTIFICATE+UPDATE+id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-delcert/{id}")
    public ResponseEntity<Object> DelCertById(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+DELIVERYCERTIFICATE+id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping ("/delete-delcert/{id}")
    public ResponseEntity<Object> deleteDelCert(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+DELIVERYCERTIFICATE+DELETE+id, HttpMethod.DELETE, Object.class);
    }

    //RELATIONSHIP SIGNAGE AND DELIVERY CERTIFICATE
    @GetMapping("/get-sdc/all/{id}")
    public ResponseEntity<Object> getSDCByIdDeliveryCertificate(@RequestHeader HttpHeaders headers, @PathVariable Long id) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+SDC+ALL+"/"+id, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-sdc")
    public ResponseEntity<Object> createSDC(@RequestBody SignageDelivCert signageDelivCert, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(signageDelivCert, headers, PATH_SERVICAD+SDC+CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-sdc/{id}")
    public ResponseEntity<Object> updateSDC(@PathVariable Long id, @RequestBody SignageDelivCert signageDelivCert, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(signageDelivCert, headers, PATH_SERVICAD+SDC+UPDATE+id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-sdc/{id}")
    public ResponseEntity<Object> SDCById(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+SDC+id, HttpMethod.GET, Object.class);
    }

    @DeleteMapping ("/delete-sdc/{id}")
    public ResponseEntity<Object> deleteSDC(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+SDC+DELETE+id, HttpMethod.DELETE, Object.class);
    }

    //FILTERS FILES DELIVERY CERTIFICATE
    @GetMapping("/get-filter/all")
    public ResponseEntity<Object> getAllFFDC(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+FILTERS+ALL, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-filter/{id}")
    public ResponseEntity<Object> getOneFFDC(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+FILTERS+id, HttpMethod.GET, Object.class);
    }

    //RELATIONSHIP FILES AND DELIVERY CERTIFICATE
    @GetMapping("/get-filesdc/all/{id}")
    public ResponseEntity<Object> getFileByIdDeliveryCertificate(@RequestHeader HttpHeaders headers, @PathVariable Long id) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+FILESDC+ALL+"/"+id, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-filesdc")
    public ResponseEntity<Object> createFDC(@RequestBody FilesDC filesDC, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(filesDC, headers, PATH_SERVICAD+FILESDC+CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-filesdc/{id}")
    public ResponseEntity<Object> updateFDC(@PathVariable Long id, @RequestBody FilesDC filesDC, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(filesDC, headers, PATH_SERVICAD+FILESDC+UPDATE+id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-filesdc/{id}")
    public ResponseEntity<Object> FDCById(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+FILESDC+id, HttpMethod.GET, Object.class);
    }

    //GENERATE FINAL REPORT
    @GetMapping("/get-report/{id}")
    public ResponseEntity<Object> reportByIdDC(@RequestParam(value = "withImageDuring")Boolean withImageDuring,@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        Map<String, Object> params = new HashMap<>();
        params.put("withImageDuring", withImageDuring);

        String pdfGenerate = ("?withImageDuring={withImageDuring}");

        if (headers != null) {
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            ProxyFacade proxy = new ProxyFacade(new RestTemplate());
            return proxy.postServiceAPI(PATH_SERVICAD+REPORT+GENERATE+id+pdfGenerate, HttpMethod.GET, requestEntity, byte[].class, params);
            //getObjectResponseEntity(withImageDuring, headers, PATH_SERVICAD+REPORT+GENERATE+id+pdfGenerate, HttpMethod.GET, byte[].class);
        }
        return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
    }

    //GENERATE CODE TEMPORAL PASSWORD
    @PostMapping("/post-codepassword")
    public ResponseEntity<Object> createCodeTemporalPassword(@RequestBody Email email) throws JsonProcessingException {
            return getObjectResponseEntity(email.getEmail(), null, PATH_SERVICAD+CODEPASSWORD, HttpMethod.POST, String.class);
    }

    //CHANGE PASSWORD
    @PostMapping("/post-changepassword")
    public ResponseEntity<Object> changePassword(@RequestBody ChangePassword changePassword, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(changePassword, headers, PATH_SERVICAD+CHANGEPASSWORD, HttpMethod.POST, String.class);
    }

    //MENU
    @GetMapping("/get-menu/all")
    public ResponseEntity<Object> getAllMenu(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+MENU+ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-menu")
    public ResponseEntity<Object> createMenu(@RequestBody Menu menu, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(menu, headers, PATH_SERVICAD+MENU+CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-menu/{id}")
    public ResponseEntity<Object> updateMenu(@PathVariable Long id, @RequestBody Menu menu, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(menu, headers, PATH_SERVICAD+MENU+UPDATE+id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-menu/{id}")
    public ResponseEntity<Object> getOneMenu(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+MENU+id, HttpMethod.GET, Object.class);
    }

    //AUTHORIZATION
    @GetMapping("/get-authz/all")
    public ResponseEntity<Object> getAllAuthorization(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+AUTHORIZATION+ALL, HttpMethod.GET, Object.class);
    }

    @PostMapping("/post-authz")
    public ResponseEntity<Object> createAuthorization(@RequestBody Authorization authorization, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(authorization, headers, PATH_SERVICAD+AUTHORIZATION+CREATE, HttpMethod.POST, Object.class);
    }

    @PutMapping("/put-authz/{id}")
    public ResponseEntity<Object> updateAuthorization(@PathVariable Long id, @RequestBody Authorization authorization, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(authorization, headers, PATH_SERVICAD+AUTHORIZATION+UPDATE+id, HttpMethod.PUT, Object.class);
    }

    @GetMapping("/get-authz/{id}")
    public ResponseEntity<Object> getOneAuthorization(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+AUTHORIZATION+id, HttpMethod.GET, Object.class);
    }

    @GetMapping("/get-authz/role/{id}")
    public ResponseEntity<Object> getAllAuthorizationByRole(@PathVariable Long id, @RequestHeader HttpHeaders headers) throws JsonProcessingException {
        return getObjectResponseEntity(null, headers, PATH_SERVICAD+AUTHORIZATION+ROLES+id, HttpMethod.GET, Object.class);
    }

    //FILE S3 PROFILE PICTURE EMPLOYEE
    @PostMapping("/post-picture/employee")
    public ResponseEntity<Object> UploadingFileEmployee(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user){
        String path = PATH_SERVICAD+AWSS3+PICTUREEMPLOYEE;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);

        return createFileS3(headers, requestEntity, path);
    }

    @PutMapping("/put-picture/employee/{idFile}")
    public ResponseEntity<Object> UpdatingFileEmployee(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user, @RequestPart(value = "key") String key, @PathVariable Long idFile){
        String path = PATH_SERVICAD+AWSS3+PICTUREEMPLOYEEUPDATE+idFile;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);
        requestEntity.add("key", key);

        return updateFileS3(headers, requestEntity, path);
    }

    @DeleteMapping("/delete-picture/employee")
    public ResponseEntity<Object> DeleteFileEmployee(@RequestHeader HttpHeaders headers, @RequestPart(value = "key")String key){
        String path = PATH_SERVICAD+AWSS3+PICTUREEMPLOYEEDELETE;
        LinkedMultiValueMap<String,Object> requestEntityGetObject = new LinkedMultiValueMap<>();

        requestEntityGetObject.add("key", key);

        return deleteFileS3(headers, requestEntityGetObject, path);
    }

    //FILE S3 COURSES EMPLOYEE
    @PostMapping("/post-course/employee")
    public ResponseEntity<Object> UploadingCourseEmployee(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user){
        String path = PATH_SERVICAD+AWSS3+COURSEEMPLOYEE;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);

        return createFileS3(headers, requestEntity, path);
    }

    @PostMapping("/post-filescourses/employee")
    public ResponseEntity<Object> UploadingCoursesEmployee(@RequestHeader HttpHeaders headers, @RequestPart(value = "file") List<MultipartFile> files, @RequestPart(value = "user")String user){
        for (MultipartFile file: files) {
            UploadingCourseEmployee(headers, file, user);
        }
        return ResponseEntity.ok().body("Archivos cargados con éxito");
    }

    @PutMapping("/put-course/employee/{idFile}")
    public ResponseEntity<Object> UpdatingCourseEmployee(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user, @RequestPart(value = "key") String key, @PathVariable Long idFile){
        String path = PATH_SERVICAD+AWSS3+COURSEEMPLOYEEUPDATE+idFile;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);
        requestEntity.add("key", key);

        return updateFileS3(headers, requestEntity, path);
    }

    @DeleteMapping("/delete-course/employee")
    public ResponseEntity<Object> DeleteCourseEmployee(@RequestHeader HttpHeaders headers, @RequestPart(value = "key")String key){
        String path = PATH_SERVICAD+AWSS3+COURSEEMPLOYEEDELETE;
        LinkedMultiValueMap<String,Object> requestEntityGetObject = new LinkedMultiValueMap<>();

        requestEntityGetObject.add("key", key);

        return deleteFileS3(headers, requestEntityGetObject, path);
    }

    //FILE S3 PROFILE PICTURE CUSTOMERS
    @PostMapping("/post-picture/customer")
    public ResponseEntity<Object> UploadingPictureCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user){
        String path = PATH_SERVICAD+AWSS3+PICTURECUSTOMER;
        LinkedMultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);

        return createFileS3(headers, requestEntity, path);
    }

    @PutMapping("/put-picture/customer/{idFile}")
    public ResponseEntity<Object> UpdatingPictureCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user, @RequestPart(value = "key") String key, @PathVariable Long idFile){
        String path = PATH_SERVICAD+AWSS3+PICTURECUSTOMERUPDATE+idFile;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);
        requestEntity.add("key", key);

        return updateFileS3(headers, requestEntity, path);
    }

    @DeleteMapping("/delete-picture/customer")
    public ResponseEntity<Object> DeletePictureCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "key")String key){
        String path = PATH_SERVICAD+AWSS3+PICTURECUSTOMERDELETE;
        LinkedMultiValueMap<String,Object> requestEntityGetObject = new LinkedMultiValueMap<>();

        requestEntityGetObject.add("key", key);

        return deleteFileS3(headers, requestEntityGetObject, path);
    }

    //FILE S3 EQUIPMENT CUSTOMER
    @PostMapping("/post-equipment/customer")
    public ResponseEntity<Object> UploadingEquipmentCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user, @RequestPart(value = "serial")String serial){
        String path = PATH_SERVICAD+AWSS3+EQUIPMENTCUSTOMER;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);
        requestEntity.add("serial", serial);

        return createFileS3(headers, requestEntity, path);
    }

    @PostMapping("/post-filesequipment/customer")
    public ResponseEntity<Object> UploadingEquipmentsCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "files")List<MultipartFile> files, @RequestPart(value = "user")String user, @RequestPart(value = "serial")String serial){
        for (MultipartFile file: files) {
            UploadingEquipmentCustomer(headers, file, user, serial);
        }
        return ResponseEntity.ok().body("Archivos cargados con éxito");
    }

    @PutMapping("/put-equipment/customer/{idFile}")
    public ResponseEntity<Object> UpdatingEquipmentCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user, @RequestPart(value = "key")String key, @RequestPart(value = "serial")String serial, @PathVariable Long idFile){
        String path = PATH_SERVICAD+AWSS3+EQUIPMENTCUSTOMERUPDATE+idFile;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);
        requestEntity.add("key", key);
        requestEntity.add("serial", serial);

        return updateFileS3(headers, requestEntity, path);
    }

    @DeleteMapping("/delete-equipment/customer")
    public ResponseEntity<Object> DeleteEquipmentCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "key")String key){
        String path = PATH_SERVICAD+AWSS3+EQUIPMENTCUSTOMERDELETE;
        LinkedMultiValueMap<String,Object> requestEntityGetObject = new LinkedMultiValueMap<>();

        requestEntityGetObject.add("key", key);

        return deleteFileS3(headers, requestEntityGetObject, path);
    }

    //FILE S3 SERVICES CUSTOMER
    @PostMapping("/post-service/customer")
    public ResponseEntity<Object> UploadingServicesCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")MultipartFile file, @RequestPart(value = "user")String user, @RequestPart(value = "orderservice")String orderService){
        String path = PATH_SERVICAD+AWSS3+FILESERVICES;
        LinkedMultiValueMap<String,Object> requestEntity = new LinkedMultiValueMap<>();

        requestEntity.add("file", file.getResource());
        requestEntity.add("user", user);
        requestEntity.add("orderservice", orderService);

        return createFileS3(headers, requestEntity, path);
    }

    @PostMapping("/post-filesservice/customer")
    public ResponseEntity<Object> UploadingFilesServicesCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "file")List<MultipartFile> files, @RequestPart(value = "user")String user, @RequestPart(value = "orderservice")String orderService){
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

        return updateFileS3(headers, requestEntity, path);
    }

    @PostMapping("/delete-service/customer")
    public ResponseEntity<Object> DeleteServicesCustomer(@RequestHeader HttpHeaders headers, @RequestPart(value = "key")String key){
        String path = PATH_SERVICAD+AWSS3+FILESERVICESDELETE;
        LinkedMultiValueMap<String,Object> requestEntityGetObject = new LinkedMultiValueMap<>();

        requestEntityGetObject.add("key", key);

        return deleteFileS3(headers, requestEntityGetObject, path);
    }

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", "*/*");
        return headers;
    }

    public String getBody(final Object data) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(data);
    }

    public ResponseEntity<Object> getObjectResponseEntity(@RequestBody Object request, HttpHeaders headerRequest, String uri, HttpMethod method, Class<?> response)
            throws JsonProcessingException {

        HttpHeaders headersWeb = this.getHeaders();
        String bodyCrewLeader = null;

        if(headerRequest != null ) {
            if (headerRequest.get("Authorization") != null && headerRequest.size() > 0) {
                headersWeb.set("Authorization", headerRequest.get("Authorization").get(0));
            } else {
                return ResponseEntity.badRequest().body("Error: no se ha encontrado el token de autorización");
            }
        }else if (headerRequest == null && uri == "http://ip-172-31-87-200.ec2.internal:8883/timesetting/name/web" || uri == "http://ip-172-31-87-200.ec2.internal:8883/timesetting/name/android"){
            headersWeb = null;
        }

        if (request != null) {
            bodyCrewLeader = this.getBody(request);
        }

        HttpEntity<String> httpEntity = new HttpEntity<>(bodyCrewLeader, headersWeb);
        ProxyFacade service = new ProxyFacade(new RestTemplate());
        return service.postServiceAPI(uri, method, httpEntity, response);
    }

    public static ResponseEntity<Object> createFileS3(HttpHeaders headers, LinkedMultiValueMap requestEntity, String path){
        HttpHeaders headersSend = new HttpHeaders();
        if (headers.get("Authorization") != null && headers.size() > 0) {
            headersSend.set("Authorization", headers.get("Authorization").get(0));
        }else{
            return ResponseEntity.badRequest().body("No trae token");
        }
        headersSend.set(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE);
        headersSend.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String,Object>> httpEntity = new HttpEntity(requestEntity, headersSend);

        ProxyFacade service = new ProxyFacade(new RestTemplate());

        return service.postServiceAPI(path, HttpMethod.POST, httpEntity, Object.class);
    }

    public static ResponseEntity<Object> updateFileS3(HttpHeaders headers, LinkedMultiValueMap requestEntity, String path){
        HttpHeaders headersSend = new HttpHeaders();
        if (headers.get("Authorization") != null && headers.size() > 0) {
            headersSend.set("Authorization", headers.get("Authorization").get(0));
        }else{
            return ResponseEntity.badRequest().body("No trae token");
        }
        headersSend.set(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE);
        headersSend.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String,Object>> httpEntity = new HttpEntity(requestEntity, headersSend);

        ProxyFacade service = new ProxyFacade(new RestTemplate());

        return service.postServiceAPI(path, HttpMethod.PUT, httpEntity, Object.class);
    }

    public static ResponseEntity<Object> deleteFileS3(HttpHeaders headers, LinkedMultiValueMap requestEntityGetObject, String path){
        HttpHeaders headersSendGet = new HttpHeaders();
        if (headers.get("Authorization") != null && headers.size() > 0) {
            headersSendGet.set("Authorization", Objects.requireNonNull(headers.get("Authorization")).get(0));
        }else{
            return ResponseEntity.badRequest().body("No trae token");
        }
        headersSendGet.set(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE);
        headersSendGet.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String,Object>> httpEntity = new HttpEntity(requestEntityGetObject, headersSendGet);

        ProxyFacade service = new ProxyFacade(new RestTemplate());

        return service.postServiceAPI(path, HttpMethod.DELETE, httpEntity, Object.class);
    }
}