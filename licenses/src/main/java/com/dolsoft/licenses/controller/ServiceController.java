package com.dolsoft.licenses.controller;
import com.dolsoft.licenses.model.Uslugi;
import com.dolsoft.licenses.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value="v1/uslugi")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @RequestMapping(value="/{uslugiId}", method = RequestMethod.GET)
    public ResponseEntity<Uslugi> getService(@PathVariable("uslugiId") String uslugiId) {
        Uslugi uslugi = serviceService.getService(uslugiId);
        uslugi.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServiceController.class).getService(uslugi.getUslugiId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServiceController.class).createService(uslugi)).withRel("createService"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServiceController.class).updateService(uslugi)).withRel("updateService"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServiceController.class).deleteService(uslugi.getUslugiId())).withRel("deleteService"));
        return ResponseEntity.ok(uslugi);
    }
    @PutMapping
    public ResponseEntity<String> updateService(@RequestBody Uslugi request) {
        return ResponseEntity.ok(serviceService.updateService(request));
    }

    @PostMapping
    public ResponseEntity<String> createService(@RequestBody Uslugi request) {
        return ResponseEntity.ok(serviceService.createService(request));
    }

    @DeleteMapping(value="/{uslugiId}")
    public ResponseEntity<String> deleteService(@PathVariable("uslugiId") String uslugiId) {
        return ResponseEntity.ok(serviceService.deleteService(uslugiId));
    }
}
