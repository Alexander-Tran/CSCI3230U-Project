package hotelsystem.service;

import hotelsystem.model.ProvidedServices;
import hotelsystem.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidedServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ProvidedServices> listAll() {
        return serviceRepository.findAll();
    }

    public void save(ProvidedServices providedServices) {
        serviceRepository.save(providedServices);
    }

    public ProvidedServices get(Long id) {
        return serviceRepository.findById(id).get();
    }
    
    public void delete(Long id) {
    	serviceRepository.deleteById(id);
    }
}

