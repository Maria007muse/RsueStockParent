package com.dolsoft.licenses.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor(force=true)
@RestResource(rel="masters", path="masters")
@Table(name="masters")
public class Master extends RepresentationModel<Master> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    @Column(name = "master_id", nullable = false)
    private String masterId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    private String position;
    private String phone;
    @Column(name="comment")
    private String comment;
    public Master withComment(String comment){
        this.setComment(comment);
        return this;
    }
}