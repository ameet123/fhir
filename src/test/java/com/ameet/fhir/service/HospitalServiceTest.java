package com.ameet.fhir.service;

import com.ameet.fhir.model.Organization;
import org.junit.Test;

public class HospitalServiceTest {

    @Test
    public void testRandomOrgCreation() {
        HospitalService hs = new HospitalService();
        Organization org = hs.randomOrganization();
        System.out.println(org);
    }

    @Test
    public void testSampleCreateOrg() {
        HospitalService hs = new HospitalService();
        Organization org = hs.insertHospital();
        System.out.println(org);
    }
}