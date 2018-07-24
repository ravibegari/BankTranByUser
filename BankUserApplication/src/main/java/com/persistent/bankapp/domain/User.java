package com.persistent.bankapp.domain;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="user_sign_up")
public class User  implements UserDetails{

	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "userId", nullable = false, updatable = false)
	    private Long userId;
	    private String firstName;
		private String lastName;
		private String username;
	    private String password;
	    private String emailId;
	    private Long   phoneNo;
	    private boolean enabled=true;

	    
	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public Long getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(Long phoneNo) {
			this.phoneNo = phoneNo;
		}
	  
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }


	    public void setEnabled(boolean enabled) {
	        this.enabled = enabled;
	    }

	   



	    @Override
	    public boolean isAccountNonExpired() {
	        // TODO Auto-generated method stub
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        // TODO Auto-generated method stub
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        // TODO Auto-generated method stub
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return enabled;
	    }

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}


	}
