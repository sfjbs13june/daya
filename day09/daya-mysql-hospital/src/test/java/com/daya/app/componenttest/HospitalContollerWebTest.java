package com.daya.app.componenttest;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.daya.app.controller.HospitalController;
import com.daya.app.model.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class})
@ActiveProfiles(value = "test")
public class HospitalContollerWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${patient.create.url}")
    String create_url;
    @Value("${patient.read.url}")
    String read_url;
    @Value("${patient.update.url}")
    String update_url;
    @Value("${patient.delete.url}")
    String delete_url;

    @Test
    public void test_createHospital() throws Exception {
        Hospital hospital=new Hospital("A","B","C");
        ResultActions resultActions=mockMvc.perform(post("/save/hospital").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("A",result.getName());
        assertEquals("B",result.getId());
    }

    @Test
    public void test_getHospital() throws Exception {
        Hospital hospital=new Hospital("A","B","C");
        ResultActions resultActions_create=mockMvc.perform(post("/save/hospital").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get("/get/hospital/B").param("id","B").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("C",result.getAddress());

    }

    @Test
    public void test_updateHospital() throws Exception {
        Hospital hospital=new Hospital("A","B","C");
        ResultActions resultActions_create=mockMvc.perform(post("/save/hospital").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put("/update/hospital").param("id","B")
                .param("name","GHI").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("GHI",result.getName());

    }

    @Test
    public void test_deleteHospital() throws Exception {
        Hospital hospital=new Hospital("A","B","C");
        ResultActions resultActions_create=mockMvc.perform(post("/save/hospital").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(delete("/delete/hospital/B").param("id","B")
                        .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
    }
    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
