package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class RecoveryRoomType extends BaseEntity {
	  @NotNull	
	  @Size(min = 5, max = 50)
	  @Column(name = "name",unique=true)
	  private String name;
}
