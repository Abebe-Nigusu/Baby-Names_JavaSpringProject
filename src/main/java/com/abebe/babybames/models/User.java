package com.abebe.babybames.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty(message="name is required!")
	    @Size(min=3, max=30, message="name must be between 3 and 30 characters")
	    private String name;
	    
	    @NotEmpty(message="Email is required!")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @NotEmpty(message="Password is required!")
	    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	    private String password;
	    
	    @Transient
	    @NotEmpty(message="Confirm Password is required!")
	    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	    private String confirm;
	    
	    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	    private List<BabyName> babyNames;
	    
	    
		public User() {
			// TODO Auto-generated constructor stub
		}
		
	
		public List<BabyName> getBabyNames() {
			return babyNames;
		}


		public void setBabyNames(List<BabyName> babyNames) {
			this.babyNames = babyNames;
		}

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}




		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getConfirm() {
			return confirm;
		}


		public void setConfirm(String confirm) {
			this.confirm = confirm;
		}
}
