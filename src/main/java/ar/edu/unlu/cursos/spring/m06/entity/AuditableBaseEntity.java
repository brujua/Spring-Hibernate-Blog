package ar.edu.unlu.cursos.spring.m06.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class AuditableBaseEntity {

    @Column(name = "created_on", nullable = false, updatable = false)
    @CreatedDate
    private Date createdOn;

    @Column(name = "modified_on")
    @LastModifiedDate
    private Date modifiedOn;

    public Date getCreatedOn() {
        return createdOn;
    }

    private void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    private void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

}
