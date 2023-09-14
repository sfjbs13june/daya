package com.daya.app.unittest;


import com.daya.app.controller.HospitalController;
import com.daya.app.model.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class HospitalControllerTest {

    @InjectMocks
    HospitalController hospitalController;

    @Test
    public void test_createHospital(){
        Hospital hospital=new Hospital("a1","b1","c1");
        Hospital result=hospitalController.createHospital(hospital);
        assertEquals(hospital.getId(),result.getId());
    }

    @Test
    public void test_getHospital(){
        Hospital hospital=new Hospital("a1","b1","c1");
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.getHospital("b1");
        assertEquals(hospital.getId(),result.getId());
    }

    @Test
    public void test_updateHospital(){
        Hospital hospital=new Hospital("a1","b1","c1");
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.updateHospital("b1","UPDATED");
        assertEquals(hospital.getName(),result.getName());
    }

    @Test
    public void test_deleteHospital(){
        Hospital hospital=new Hospital("a1","b1","c1");
        hospitalController.createHospital(hospital);
        hospitalController.deleteHospital("b1");
        assertNull(hospitalController.getHospital("b1"));
    }
}
