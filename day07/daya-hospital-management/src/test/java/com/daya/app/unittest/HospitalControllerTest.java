package com.daya.app.unittest;

import com.daya.app.controller.HospitalController;
import com.daya.app.controller.PatientController;
import com.daya.app.model.Hospital;
import com.daya.app.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HospitalControllerTest {

    @InjectMocks
    private HospitalController hospitalController=new HospitalController();
    private PatientController patientController=new PatientController();

    @Test
    public void test_createHospital(){
        Hospital hospital=new Hospital("Manipal hospital", "Bangalore","77568");
        Hospital result=hospitalController.createHospital(hospital);
        assertEquals(hospital.getHospital_name(),result.getHospital_name());
        assertEquals(hospital.getAddress(),result.getAddress());
        assertEquals(hospital.getId(),result.getId());
    }
    @Test
    public void test_readHospital(){
        Hospital hospital=new Hospital("Manipal hospital", "Bangalore","77568");
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.readHospital("Manipal hospital");
        assertEquals("Manipal hospital",result.getHospital_name());
        assertEquals("Bangalore",result.getAddress());
        assertEquals("77568",result.getId());
    }

    @Test
    public void test_updateHospital(){
        Hospital hospital=new Hospital("Manipal hospital", "Bangalore","77568");
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.updateHospital("Manipal hospital","Delhi");
        assertEquals("Manipal hospital",result.getHospital_name());
        assertEquals("Delhi",result.getAddress());
        assertEquals("77568",result.getId());
    }

    @Test
    public void test_deleteHospital(){
        Hospital hospital=new Hospital();
        hospital.setHospitalName("Manipal hospital");
        hospital.setAddress("Bangalore");
        hospital.setId("77568");

        hospitalController.createHospital(hospital);
        hospitalController.deleteHospital("Manipal hospital");
        Hospital result=hospitalController.readHospital("Manipal hospital");
        assertNull(result);
    }



    @Test
    public void test_createPatient(){
        Patient patient=new Patient("Patient1","1", "Manipal hospital","Dengue fever");
        Patient result=patientController.createPatient(patient);
        assertEquals(patient.getPatient_name(),result.getPatient_name());
        assertEquals(patient.getHospital_name(),result.getHospital_name());
        assertEquals(patient.getPatient_id(),result.getPatient_id());
    }

    @Test
    public void test_readPatient(){
        Patient patient=new Patient("patient1","1", "Manipal hospital","Dengue fever");
        patientController.createPatient(patient);
        Patient result=patientController.readPatient("patient1");
        assertEquals("patient1",result.getPatient_name());
        assertEquals("1",result.getPatient_id());
        assertEquals("Manipal hospital",result.getHospital_name());
        assertEquals("Dengue fever",result.getDisease());
    }

    @Test
    public void test_updatePatient(){
        Patient patient=new Patient("patient1","1", "Manipal hospital","Dengue fever");
        patientController.createPatient(patient);
        Patient result=patientController.updatePatient("patient1","hospital2");
        assertEquals("patient1",result.getPatient_name());
        assertEquals("1",result.getPatient_id());
        assertEquals("hospital2",result.getHospital_name());
        assertEquals("Dengue fever",result.getDisease());
    }

    @Test
    public void test_deletePatient() {
        Patient patient=new Patient();
        patient.setPatient_name("patient1");
        patient.setPatient_id("1");
        patient.setHospital_name("Manipal hospital");
        patient.setDisease("Dengue fever");

        patientController.createPatient(patient);
        patientController.deletePatient("Patient1");
        Patient result=patientController.readPatient("Patient1");
        assertNull(result);
    }
}
