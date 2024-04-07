package com.dolsoft.licenses.service;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import com.dolsoft.licenses.model.License;
import com.dolsoft.licenses.repository.LicenseRepository;
import com.dolsoft.licenses.config.ServerConfig;
@Service
public class LicenseService {
    @Autowired
    private MessageSource messages;
    @Autowired
    private LicenseRepository licenseRepository;
    @Autowired
    private ServerConfig config;
    public License getLicense(Long id) {
        License license = licenseRepository.findById(id).get();
        if(license == null) {
            throw new
                    IllegalArgumentException(String.format(messages
                    .getMessage("license.search.error.message",
                            null, null),id));
        }
        return license.withComment(config.getProperty());
    }
    public License createLicense(License license){
        if(license != null) {
            license.setLicenseId(UUID.randomUUID().toString());
            licenseRepository.save(license);
            return license.withComment(config.getProperty());
        }
        return null;
    }
    public License updateLicense(License license){
        if(license != null) {
            licenseRepository.save(license);
            return license.withComment(config.getProperty());
        }
        return null;
    }
    public License deleteLicense(License license){
        if(license != null) {
            licenseRepository.delete(license);
            return license.withComment(config.getProperty());
        }
        return null;
    }
}
