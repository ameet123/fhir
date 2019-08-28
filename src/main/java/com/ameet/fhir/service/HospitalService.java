package com.ameet.fhir.service;

import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.rest.api.MethodOutcome;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.ameet.fhir.config.Constants.JSON_FMT;
import static com.ameet.fhir.config.Constants.SAMPLE_ORG;

@Service
public class HospitalService {
    private Random random;

    public HospitalService() {
        random = new Random();
    }

    public Bundle insertHospitalViaBundle() {
        Organization o = randomOrganization();
        Bundle bundle = new Bundle();
        bundle.setType(Bundle.BundleType.TRANSACTION);
        bundle.addEntry().setFullUrl(o.getId()).setResource(o).
                getRequest().
                setUrl("Organization")
                .setMethod(Bundle.HTTPVerb.POST);

        return CommonServices.client.transaction().withBundle(bundle).execute();
    }

    public Organization insertHospital() {
        Organization o = randomOrganization();
        MethodOutcome responseId = CommonServices.client.create().resource(o).execute();
        return (Organization) responseId.getResource();
    }

    public Organization getHospital(String id) throws URISyntaxException {
        URI u = new URI(SAMPLE_ORG + id + "/" + JSON_FMT);
        return CommonServices.client.read().resource(Organization.class).withId(id).execute();
    }

    public Bundle queryHospitalByAddressAttributes() {
        return CommonServices.client.search().forResource(Organization.class).
                where(Organization.ADDRESS_POSTALCODE.matches().values("30309"))
                .returnBundle(Bundle.class).execute();
    }
    public Bundle queryHospitalByName(String name) {
        return CommonServices.client.search().forResource(Organization.class).
                where(Organization.NAME.matches().values(name))
                .returnBundle(Bundle.class).execute();
    }

    Organization randomOrganization() {
        Organization org = new Organization();

        String valueId = randomId();
        org.setId(IdDt.newRandomUuid());
        //Address
        Address a1 = new Address();
        a1.setCity("Atlanta");
        a1.setCountry("USA");
        a1.setPostalCode("30309");
        a1.setState("GA");
        List<Address> addresses = new ArrayList<>();
        addresses.add(a1);
        org.setAddress(addresses);
        // identifier
        Identifier identifier = new Identifier();
        identifier.setSystem("urn:ietf:rfc:3986");
        identifier.setValue(valueId);
        ArrayList<Identifier> identifiers = new ArrayList<Identifier>();
        identifiers.add(identifier);
        org.setIdentifier(identifiers);
        String name = "Fhire-JJ-Acn-" + random.nextInt(999999) + 1;
        org.setName(name);
        Narrative n = new Narrative();
        String divMine = "<div xmlns=\"http://www.w3.org/1999/xhtml\"> <p>" + name + "</p> </div>";
        XhtmlNode node = new XhtmlNode();
        node.setValue(divMine);
        n.setDiv(node);
        Narrative.NarrativeStatus status = Narrative.NarrativeStatus.fromCode("generated");
        n.setStatus(status);
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
