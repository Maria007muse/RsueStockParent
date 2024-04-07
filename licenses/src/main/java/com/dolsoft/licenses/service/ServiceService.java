package com.dolsoft.licenses.service;

import com.dolsoft.licenses.model.Uslugi;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ServiceService {
    public Uslugi getService(String uslugiId) {
        Uslugi uslugi = new Uslugi();
        uslugi.setId(new Random().nextInt(1000));
        uslugi.setUslugiId(uslugiId);
        uslugi.setName("Some Service");
        uslugi.setCost(100.0);
        uslugi.setDuration(60);
        return uslugi;
    }

    public String createService(Uslugi uslugi) {
        String responseMessage = null;
        if(uslugi != null) {
            responseMessage = String.format("This is the post and the object is: %s",uslugi.toString());
        }
        return responseMessage;
    }

    public String updateService(Uslugi uslugi) {
        String responseMessage = null;
        if (uslugi != null) {
            responseMessage = String.format("This is the put and the object is: %s", uslugi.toString());
        }
        return responseMessage;
    }

    public String deleteService(String uslugiId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting service with id %s", uslugiId);
        return responseMessage;
    }
}

