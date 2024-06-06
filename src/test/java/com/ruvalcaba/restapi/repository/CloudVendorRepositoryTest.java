package com.ruvalcaba.restapi.repository;

import com.ruvalcaba.restapi.model.CloudVendor;
import com.ruvalcaba.restapi.repository.CloudVendorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest{

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor(1,"xx-xx-xx-xx","Tala","Doña Mary");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // Test for vendor found
    @Test
    void testFindByName_Found(){
        List<CloudVendor> vendorList = cloudVendorRepository.findByName("Doña Mary");
        assertThat(vendorList.get(0).getId()).isEqualTo(cloudVendor.getId());
        assertThat(vendorList.get(0).getName()).isEqualTo(cloudVendor.getName());
    }

    // Test for vendor not found
    @Test
    void testFindByName_NotFound(){
        List<CloudVendor> vendorList = cloudVendorRepository.findByName("Vega");
        assertThat(vendorList.isEmpty()).isTrue();
    }
}