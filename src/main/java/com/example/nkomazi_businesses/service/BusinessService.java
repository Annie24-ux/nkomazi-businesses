package com.example.nkomazi_businesses.service;

import com.example.nkomazi_businesses.persistence.BusinessRepository;
import com.example.nkomazi_businesses.model.Business;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }


    public Iterable<Business> get() {
        return businessRepository.findAll();
    }

    public Optional<Business> get(Integer id) {
        return businessRepository.findById(id);
    }

    public void remove(Integer id) {
        businessRepository.deleteById(id);
    }

    public Business save(Integer id, Business business) {

        businessRepository.save(business);
        return business;
        }


    public boolean isBusinessADuplicate(Business x) {
        List<Business> allBusinesses = (List<Business>) get();

        if(allBusinesses == null) return false;

        for(Business business: allBusinesses) {
            if(business.getName().equals(x.getName()) && business.getLocation().equals(x.getLocation())) {
                return true;
            }
        }
        return false;
    }

    public Business updateBusiness(Integer id, Business updatedBusiness) {
        Optional<Business> existingBusiness = businessRepository.findById(id);

        if(existingBusiness.isPresent()) {
            Business newBusinessData = existingBusiness.get();
            newBusinessData.setName(updatedBusiness.getName());
            newBusinessData.setDescription(updatedBusiness.getDescription());
            newBusinessData.setLocation(updatedBusiness.getLocation());
            newBusinessData.setContact(updatedBusiness.getContact());
            newBusinessData.setOwner(updatedBusiness.getOwner());

            if(isBusinessADuplicate(newBusinessData)) {
                System.out.println("Choose another name or location");
                return businessRepository.save(null);
            } else {
                return businessRepository.save(newBusinessData);
            }
        }
        return businessRepository.save(null);
    }

    public List<Optional<Business>> getBusinessesByNames(String owner) {

        Iterable<Business> storedBusinesses = get();
        List<Optional<Business>> ownersBusiness = new ArrayList<>();


        for(Business business: storedBusinesses){
            String person = business.getOwner().replaceAll("\\s+", "");
            if(person.equalsIgnoreCase(owner)){
                Optional<Business> x = get(business.getId());
                ownersBusiness.add(x);
            }
        }
        return ownersBusiness;
    }
}
