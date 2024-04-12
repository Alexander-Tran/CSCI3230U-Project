package hotelsystem.service;

import hotelsystem.model.ProvidedServices;
import hotelsystem.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidedServiceService {

	// Autowire services repo
    @Autowired
    private ServiceRepository serviceRepository;

    // Return list of all services
    public List<ProvidedServices> listAll() {
        return serviceRepository.findAll();
    }
    
    // Save services object
    public void save(ProvidedServices providedServices) {
        serviceRepository.save(providedServices);
    }

    // Return services by ID
    public ProvidedServices get(Long id) {
        return serviceRepository.findById(id).get();
    }
    
    // Delete services by ID
    public void delete(Long id) {
    	serviceRepository.deleteById(id);
    }
}

