package com.example.nkomazi_businesses.persistence;

import com.example.nkomazi_businesses.model.Business;
import org.springframework.data.repository.CrudRepository;

public interface BusinessRepository extends CrudRepository <Business, Integer> {
}
