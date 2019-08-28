package com.ameet.fhir.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.springframework.web.client.RestTemplate;

import static com.ameet.fhir.config.Constants.SAMPLE_HOST;

public class CommonServices {
    public static RestTemplate restTemplate = new RestTemplate();
    public static FhirContext ctx = FhirContext.forR4();
    public static IParser jsonParser = ctx.newJsonParser().setPrettyPrint(true);
    public static IGenericClient client = ctx.newRestfulGenericClient(SAMPLE_HOST);
}
