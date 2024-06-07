package ru.mirea.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.edu.model.ServiceType;
import ru.mirea.edu.repository.ServiceTypeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public ServiceType createServiceType(ServiceType serviceType){
        serviceTypeRepository.save(serviceType);
        return serviceType;
    }

    public ServiceType updateServiceType(int id, ServiceType serviceType){
        ServiceType existingServiceType = serviceTypeRepository.findById(id)
                .orElseThrow(() -> new Error("Тип сервиса не найден с id: " + id));

        // Обновляем поля существующего клиента
        existingServiceType.updateDetails(serviceType);

        // Сохраняем обновленного клиента
        return serviceTypeRepository.save(serviceType);
    }
    //    public int deleteClient(int Id);
    public ServiceType getServiceType(int Id){
        return serviceTypeRepository.findById(Id).orElseThrow(() -> new NoSuchElementException("Типа сервиса с Id " + Id + " не найдено"));
    };

    public List<ServiceType> getAllServiceTypes(){
        return serviceTypeRepository.findAll();
    };

    public void deleteServiceType(int id){
        ServiceType existingServiceType = serviceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Тип сервиса не найден с id: " + id));

        serviceTypeRepository.delete(existingServiceType);
    }
}
