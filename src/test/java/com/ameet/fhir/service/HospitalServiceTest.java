package com.ameet.fhir.service;

import com.ameet.fhir.utils.FhireUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Organization;
import org.junit.Test;

import java.net.URISyntaxException;

public class HospitalServiceTest {

    @Test
    public void testRandomOrgCreation() throws JsonProcessingException {
        HospitalService hs = new HospitalService();
        Organization org = hs.randomOrganization();

        System.out.println(CommonServices.jsonParser.encodeResourceToString(org));
        System.out.println(org.getIdentifier().get(0).getValue());
    }

    @Test
    public void testSampleCreateOrgViaBundle() {
        HospitalService hs = new HospitalService();
        Bundle bundle = hs.insertHospitalViaBundle();
        System.out.println(FhireUtils.jsonToString(bundle));
    }

    @Test
    public void testSampleCreateOrg() {
        HospitalService hs = new HospitalService();
        Organization org = hs.insertHospital();
        System.out.println(FhireUtils.jsonToString(org));
    }


    @Test
    public void testGetHospital() throws URISyntaxException {
        HospitalService hs = new HospitalService();
        Organization org = hs.getHospital("154951");
        System.out.println(FhireUtils.jsonToString(org));
    }

    @Test
    public void testQueryHospitalByAddress() {
        HospitalService hs = new HospitalService();
        Bundle bundle = hs.queryHospitalByAddressAttributes();
        Organization org = (Organization) bundle.getEntry().get(0).getResource();
        System.out.println(FhireUtils.jsonToString(org));
    }

    @Test
    public void testQueryHospitalByName() {
        String name = "Fhire-JJ-Acn-9636311";
        HospitalService hs = new HospitalService();
        Bundle bundle = hs.queryHospitalByName(name);
        System.out.println("# of entries=" + bundle.getEntry().size());
        Organization org = (Organization) bundle.getEntry().get(0).getResource();
        System.out.println(FhireUtils.jsonToString(org));
    }
}