package com.ruvalcaba.restapi.controller;

import com.ruvalcaba.restapi.model.CloudVendor;
import com.ruvalcaba.restapi.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    // Get details of a specific vendor
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("{id}")
    public CloudVendor getCloudVendorDetails(@PathVariable Integer id){
        return cloudVendorService.getCloudVendor(id);
    }

    // Get a list of all vendors
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("all")
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    // Create a new vendor
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("create")
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Created successfully";
    }

    // Update information of a vendor
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("update")
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Vendor " + cloudVendor.getId() + " updated successfully";
    }

    // Delete the entry of a vendor via ID
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("delete/{id}")
    public String deleteCloudVendor(@PathVariable Integer id){
        cloudVendorService.deleteCloudVendor(id);
        return "Vendor deleted successfully";
    }
}