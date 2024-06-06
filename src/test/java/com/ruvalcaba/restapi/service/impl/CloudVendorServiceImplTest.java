package com.ruvalcaba.restapi.service.impl;

import com.ruvalcaba.restapi.model.CloudVendor;
import com.ruvalcaba.restapi.repository.CloudVendorRepository;
import com.ruvalcaba.restapi.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor(1,"xx-xx-xx-xx","Tala","Doña Mary");

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAllCloudVendorsTest() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getId()).isEqualTo(cloudVendor.getId());
    }

    @Test
    void getCloudVendorTest() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById(1)).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor(1).getName()).isEqualTo(cloudVendor.getName());
    }

    @Test
    void createCloudVendorTest() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Vendor created");
    }

    @Test
    void updateCloudVendorTest() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Vendor updated");
    }

    @Test
    void deleteCloudVendorTest() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor(any())).isEqualTo("Vendor deleted");
    }

    @Test
    void getCloudVendorByNameTest(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByName("Doña Mary")).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
        assertThat(cloudVendorService.getCloudVendorByName("Doña Mary").get(0).getId()).isEqualTo(cloudVendor.getId());
    }
}