package ru.mirea.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.model.ServiceType;
import ru.mirea.edu.service.ClientService;
import ru.mirea.edu.service.ServiceTypeService;

import java.util.List;

@RestController
@RequestMapping("/serviceType")
public class ServiceTypeController {
    @Autowired
    ServiceTypeService serviceTypeService;

    @GetMapping("/{id}")
    public ServiceType getServiceTypeOne(@PathVariable("id") int id){
        return serviceTypeService.getServiceType(id);
    }

    @GetMapping
    public List<ServiceType> getServiceTypes(){
        return serviceTypeService.getAllServiceTypes();
    }

    @PostMapping
    public ServiceType createServiceType(@RequestBody ServiceType serviceType){
        return serviceTypeService.createServiceType(serviceType);
    }

    @PutMapping("/{id}")
    public ServiceType updateServiceType(@PathVariable("id") int id, @RequestBody ServiceType serviceType){
        return serviceTypeService.updateServiceType(id, serviceType);
    }

    @DeleteMapping("/{id}")
    public String deleteServiceType(@PathVariable("id") int id){
        serviceTypeService.deleteServiceType(id);
        return "OK";
    }
}
