package web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "surname")
   private String surName;

   @Column(name = "email")
   private String email;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.name = firstName;
      this.surName = lastName;
      this.email = email;
   }
}
