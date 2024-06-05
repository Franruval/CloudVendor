package com.ruvalcaba.restapi.repository;

import com.ruvalcaba.restapi.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, Integer>{
    List<CloudVendor> findByName(String name);
}


