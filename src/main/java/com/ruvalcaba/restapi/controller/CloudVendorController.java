package com.ruvalcaba.restapi.controller;

import com.ruvalcaba.restapi.model.CloudVendor;
import com.ruvalcaba.restapi.response.ResponseHandler;
import com.ruvalcaba.restapi.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("{id}")
    public ResponseEntity<Object> getCloudVendor(@PathVariable Integer id){
        return ResponseHandler.responseBuilder("Details of vendor with id=" + id,
                HttpStatus.OK, cloudVendorService.getCloudVendor(id));
    }

    // Get a list of all vendors
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("all")
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    // Create a new vendor
    @PostMapping("create")
    public ResponseEntity<Object> createCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseHandler.responseBuilder("Vendor created",HttpStatus.CREATED);
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