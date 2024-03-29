package com.project.jparestfulapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Member {
   @Id
   @Column(name = "MEMBER_ID")
   private Long id;
   private String name;
}
