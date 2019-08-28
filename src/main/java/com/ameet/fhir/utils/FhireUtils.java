package com.ameet.fhir.utils;

import com.ameet.fhir.service.CommonServices;
import org.hl7.fhir.instance.model.api.IBaseResource;

public class FhireUtils {
    public static String jsonToString(IBaseResource resource) {
        return CommonServices.ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(resource);
    }
}
