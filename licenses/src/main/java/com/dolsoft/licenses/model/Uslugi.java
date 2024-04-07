package com.dolsoft.licenses.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class Uslugi extends RepresentationModel<Uslugi> implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    private String uslugiId;
    private String name;
    private double cost;
    private int duration;
}
