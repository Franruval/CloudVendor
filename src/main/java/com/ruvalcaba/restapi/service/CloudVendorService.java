package com.ruvalcaba.restapi.service;

import com.ruvalcaba.restapi.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    public List<CloudVendor> getAllCloudVendors();
    public CloudVendor getCloudVendor(Integer id);
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(Integer id);
}
