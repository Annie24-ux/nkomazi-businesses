package com.example.nkomazi_businesses.api;

import com.example.nkomazi_businesses.service.BusinessService;
import com.example.nkomazi_businesses.model.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/businesses")
@CrossOrigin(origins = "http://localhost:63342")

public class BusinessController {

    @Autowired
    private BusinessService businessService;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Business>> getBusinessById(@PathVariable Integer id) {

        Optional<Business> businessById = businessService.get(id);

        if(businessById.isPresent()) {
            return ResponseEntity.ok(Optional.of(businessById.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<Iterable<Business>> getBusinesses() {

        Iterable<Business> businesses = businessService.get();
        return ResponseEntity.ok(businesses);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Business> deleteBusinessById(@PathVariable Integer id) {
        Optional<Business> businessToBeDeleted = businessService.get(id);
        if (businessToBeDeleted == null) {
            return ResponseEntity.notFound().build();
        } else {
            businessService.remove(id);
            return ResponseEntity.noContent().build();
        }
    }


    @GetMapping("owner/{owner}")
    public ResponseEntity<List<Optional<Business>>> getBusinessesByOwner(@PathVariable String owner) {

        List<Optional<Business>> businessesUnderName = businessService.getBusinessesByNames(owner);
        return ResponseEntity.status(HttpStatus.OK).body(businessesUnderName);

    }


    @PostMapping
    public ResponseEntity<Business> createBusiness(@RequestBody Business business) {

        if(businessService.isBusinessADuplicate(business)){
            System.out.println("Business name " + business.getName() + " and located " + "in " + business.getLocation() +  " already exists!." + " Kindly change one of the two.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } else {
            businessService.save(business.getId(), business);
            return ResponseEntity.status(HttpStatus.CREATED).body(business);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Business> updateBusiness(@PathVariable Integer id,
    @RequestBody Business updatedBusiness) {

        try {
            Business newBusiness = businessService.updateBusiness(id, updatedBusiness);
            return ResponseEntity.ok(newBusiness);
        } catch (RuntimeException e) {
            System.out.println("Duplicates are not allowed.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }


}

