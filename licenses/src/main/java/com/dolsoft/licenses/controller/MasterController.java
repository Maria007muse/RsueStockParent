package com.dolsoft.licenses.controller;

import com.dolsoft.licenses.model.Master;
import com.dolsoft.licenses.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value="v1/master")
public class MasterController {
    @Autowired
    private MasterService masterService;
    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public ResponseEntity<Master> getMaster(@PathVariable("Id") Long Id) {
        Master master = masterService.getMaster(Id);
        master.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MasterController.class).getMaster(Id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MasterController.class).createMaster(master)).withRel("createMaster"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MasterController.class).updateMaster(master)).withRel("updateMaster"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MasterController.class).deleteMaster(Id)).withRel("deleteMaster"));
        return ResponseEntity.ok(master);
    }
    @PutMapping
    public ResponseEntity<Master> updateMaster(@RequestBody Master request) {
        return
                ResponseEntity.ok(masterService.updateMaster(request));
    }
    @PostMapping
    public ResponseEntity<Master> createMaster(@RequestBody Master request) {
        return
                ResponseEntity.ok(masterService.createMaster(request));
    }
    @DeleteMapping(value="/{Id}")
    public ResponseEntity<String> deleteMaster(@PathVariable("Id") Long id) {
        Master master = masterService.getMaster(id);
        if (master == null) {
            return ResponseEntity.notFound().build();
        }
        masterService.deleteMaster(master);
        return ResponseEntity.ok("Master with id " + id + " has been deleted successfully.");
    }
}
