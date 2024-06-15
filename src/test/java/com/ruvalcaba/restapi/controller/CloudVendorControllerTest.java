package com.ruvalcaba.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ruvalcaba.restapi.model.CloudVendor;
import com.ruvalcaba.restapi.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
// Import needed for test methods
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendor1;
    CloudVendor cloudVendor2;
    List<CloudVendor> cloudVendors = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendor1 = new CloudVendor(1,"xx-xx-xx-xx-xx", "Tala", "Little Caesars");
        cloudVendor2 = new CloudVendor(1,"xx-xx-xx-xx-xx", "Guadalajara", "Applebee's");
        cloudVendors.add(cloudVendor1);
        cloudVendors.add(cloudVendor2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCloudVendorTest() throws Exception{
        when(cloudVendorService.getCloudVendor(1)).thenReturn(cloudVendor1);
        this.mockMvc.perform(get("/cloud-vendor/id/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getCloudVendorByNameTest() throws Exception{
        when(cloudVendorService.getCloudVendorByName("Little Caesars"))
                .thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor1)));
        this.mockMvc.perform(get("/cloud-vendor/name/Little Caesars"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllCloudVendorsTest() throws Exception{
        when(cloudVendorService.getAllCloudVendors()).thenReturn((cloudVendors));
        this.mockMvc.perform(get("/cloud-vendor/all")).andDo(print()).andExpect(status().isOk());
    }   // The get method needs to be from org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

    @Test
    void createCloudVendorTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendor1);

        when(cloudVendorService.createCloudVendor(cloudVendor1)).thenReturn("Vendor created");
        this.mockMvc.perform(post("/cloud-vendor/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void updateCloudVendorTest() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendor1);

        when(cloudVendorService.updateCloudVendor(cloudVendor1)).thenReturn("Vendor updated");
        this.mockMvc.perform(put("/cloud-vendor/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteCloudVendorTest() throws Exception {
        when(cloudVendorService.deleteCloudVendor(1)).thenReturn("Vendor deleted");
        this.mockMvc.perform(delete("/cloud-vendor/delete/1")).andDo(print()).andExpect(status().isOk());
    }
}