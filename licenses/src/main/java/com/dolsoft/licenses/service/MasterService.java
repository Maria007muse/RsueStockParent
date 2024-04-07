package com.dolsoft.licenses.service;

import com.dolsoft.licenses.config.ServerConfig;
import com.dolsoft.licenses.model.Master;
import com.dolsoft.licenses.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MasterService {

    @Autowired
    private MessageSource messages;
    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private ServerConfig config;
    public Master getMaster(Long id) {
        Master master = masterRepository.findById(id).get();
        if(master == null) {
            throw new IllegalArgumentException(String.format(messages
                    .getMessage("master.search.error.message",
                            null, null),id));
        }
        return master.withComment(config.getProperty());
    }
    public Master createMaster(Master master){
        if(master != null) {
            master.setMasterId(UUID.randomUUID().toString());
            masterRepository.save(master);
            return master.withComment(config.getProperty());
        }
        return null;
    }
    public Master updateMaster(Master master){
        if(master != null) {
            masterRepository.save(master);
            return master.withComment(config.getProperty());
        }
        return null;
    }
    public Master deleteMaster(Master master){
        if(master != null) {
            masterRepository.delete(master);
            return master.withComment(config.getProperty());
        }
        return null;
    }
}