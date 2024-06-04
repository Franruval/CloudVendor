package com.ruvalcaba.restapi.service.impl;

import com.ruvalcaba.restapi.model.CloudVendor;
import com.ruvalcaba.restapi.repository.CloudVendorRepository;
import com.ruvalcaba.restapi.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    } 

    @Override
    public CloudVendor getCloudVendor(Integer id) {
        return cloudVendorRepository.findById(id).get();
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Vendor created";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Vendor updated";
    }

    @Override
    public String deleteCloudVendor(Integer id) {
        cloudVendorRepository.deleteById(id);
        return "Vendor deleted";
    }
}
