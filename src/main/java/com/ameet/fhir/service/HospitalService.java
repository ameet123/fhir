package com.ameet.fhir.service;

import com.ameet.fhir.config.Constants;
import com.ameet.fhir.model.Identifier;
import com.ameet.fhir.model.Narrative;
import com.ameet.fhir.model.Organization;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private Random random;


    public HospitalService() {
        random = new Random();
    }

    public Organization insertHospital() {
        Organization o = randomOrganization();
        return CommonServices.restTemplate.postForObject(Constants.SAMPLE_ORG, o, Organization.class);
    }

    Organization randomOrganization() {
        Organization org = new Organization();

        String valueId = randomId();
        org.setId(valueId);
        Identifier identifier = new Identifier();
        identifier.setSystem("urn:ietf:rfc:3986");
        identifier.setValue(valueId);

        org.setIdentifier(new Identifier[]{identifier});
        String name = "Fhire-JJ-Acn-" + random.nextInt(999999) + 1;
        org.setName(name);
        Narrative n = new Narrative();
        String divMine = "<div xmlns=\"http://www.w3.org/1999/xhtml\"> <p>" + name + "</p> </div>";
        n.setDiv(divMine);
        n.setStatus("generated");
        org.setText(n);
        return org;
    }

    private String randomId() {
        ArrayList<Integer> components = new ArrayList<Integer>();
        components.add(random.nextInt(8) + 1);
        components.add(random.nextInt(98) + 1);
        components.add(random.nextInt(998) + 1);
        components.add(random.nextInt(8) + 1);
        components.add(random.nextInt(999998) + 1);
        components.add(random.nextInt(98) + 1);
        components.add(random.nextInt(8) + 1);
        return components.stream().map(Object::toString).collect(Collectors.joining("."));
    }
}
