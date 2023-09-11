package com.daya.app.componenttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.daya.app.controller.HospitalController;
import com.daya.app.controller.PatientController;
import com.daya.app.model.Hospital;
import com.daya.app.model.Patient;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class,PatientController.class})
@ActiveProfiles(value = "test")
public class HospitalControllerWebTests {
    @Autowired
    private MockMvc mockMvc;

    @Value("${hospital.create.url}")
    String create_url;
    @Value("${hospital.read.url}")
    String read_url;
    @Value("${hospital.update.url}")
    String update_url;
    @Value("${hospital.delete.url}")
    String delete_url;

    @Value("${patient.create.url}")
    String creatept_url;
    @Value("${patient.read.url}")
    String readpt_url;
    @Value("${patient.update.url}")
    String updatept_url;
    @Value("${patient.delete.url}")
    String deletept_url;


    @Test
    public void test_saveHospital() throws Exception {
        Hospital hospital = new Hospital("hospital1", "Bangalore","101");
        ResultActions resultActions = mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("hospital1", result.getHospital_name());
        assertEquals("Bangalore", result.getAddress());
        assertEquals("101", result.getId());
    }

    @Test
    public void test_readHospital() throws Exception {
        Hospital hospital = new Hospital("hospital1", "Bangalore", "101");
        ResultActions resultActions_create = mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions = mockMvc.perform(get(read_url).param("hospital_name", "hospital1").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("hospital1", result.getHospital_name());
        assertEquals("Bangalore", result.getAddress());
        assertEquals("101", result.getId());
    }

    @Test
    public void test_updateHospital() throws Exception {
        Hospital hospital = new Hospital("hospital1", "Bangalore", "101");
        ResultActions resultActions_create = mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions = mockMvc.perform(put(update_url)
                .param("hospital_name", "hospital1")
                .param("address", "Delhi")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("hospital1", result.getHospital_name());
        assertEquals("Delhi", result.getAddress());
        assertEquals("101", result.getId());
    }

    public void test_deleteHospital() throws Exception {
        Hospital hospital = new Hospital("hospital1", "Bangalore", "101");
        ResultActions resultActions_create = mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions = mockMvc.perform(delete(delete_url).param("hospital_name", "hospital1").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertNull(result);

    }
    @Test
    public void test_savePatient() throws Exception {
        Patient patient = new Patient("patient1", "1", "hospital1","Dengue fever");
        ResultActions resultActions = mockMvc.perform(post(creatept_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("patient1", result.getPatient_name());
        assertEquals("1", result.getPatient_id());
        assertEquals("hospital1", result.getHospital_name());
        assertEquals("Dengue fever", result.getDisease());

    }

    @Test
    public void test_readPatient() throws Exception {
        Patient patient = new Patient("patient1", "1", "hospital1", "Dengue fever");
        ResultActions resultActions_create = mockMvc.perform(post(creatept_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions = mockMvc.perform(get(readpt_url).param("patient_name", "patient1").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("patient1", result.getPatient_name());
        assertEquals("1", result.getPatient_id());
        assertEquals("hospital1", result.getHospital_name());
        assertEquals("Dengue fever", result.getDisease());
    }

    @Test
    public void test_updatePatient() throws Exception {
        Patient patient = new Patient("patient1", "1", "hospital1","Dengue fever");
        ResultActions resultActions_create = mockMvc.perform(post(creatept_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions = mockMvc.perform(put(updatept_url)
                .param("patient_name", "patient1")
                .param("hospital_name", "hospital2")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("patient1", result.getPatient_name());
        assertEquals("1", result.getPatient_id());
        assertEquals("hospital2", result.getHospital_name());
        assertEquals("Dengue fever", result.getDisease());
    }

    public void test_deletePatient() throws Exception {
        Patient hospital = new Patient("patient1", "1", "hospital2","Dengue fever");
        ResultActions resultActions_create = mockMvc.perform(post(creatept_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions = mockMvc.perform(delete(deletept_url).param("patient_name", "patient1").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertNull(result);

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