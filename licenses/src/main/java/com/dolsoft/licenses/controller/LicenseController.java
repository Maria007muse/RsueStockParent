package com.dolsoft.licenses.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.dolsoft.licenses.model.License;
import com.dolsoft.licenses.service.LicenseService;
@RestController
@RequestMapping(value="v1/organization/{organizationId}/licenses")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;
    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public ResponseEntity<License> getLicense(
            @PathVariable("Id") Long Id) {
        License license = licenseService.getLicense(Id);
        license.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class)
                                .getLicense(Id))
                        .withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class)
                                .createLicense(license))
                        .withRel("createLicense"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class)
                                .updateLicense(license))
                        .withRel("updateLicense"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class)
                                .deleteLicense(license))
                        .withRel("deleteLicense"));
        return ResponseEntity.ok(license);
    }
    @PutMapping
    public ResponseEntity<License> updateLicense(
            @RequestBody License request) {
        return
                ResponseEntity.ok(licenseService.updateLicense(request));
    }
    @PostMapping
    public ResponseEntity<License> createLicense(
            @RequestBody License request) {
        return
                ResponseEntity.ok(licenseService.createLicense(request));
    }
    @DeleteMapping(value="/{Id}")
    public ResponseEntity<License> deleteLicense(
            @RequestBody License request) {
        return
                ResponseEntity.ok(licenseService.deleteLicense(request));
    }
}