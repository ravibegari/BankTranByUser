package com.persistent.bankapp.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.persistent.bankapp.security.Authority;
import com.persistent.bankapp.security.UserRole;

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

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JsonIgnore
	    private Set<UserRole> userRoles = new HashSet<>();

	    public Set<UserRole> getUserRoles() {
	        return userRoles;
	    }

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
	    public void setUserRoles(Set<UserRole> userRoles) {
	        this.userRoles = userRoles;
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
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        Set<GrantedAuthority> authorities = new HashSet<>();
	        userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
	        return authorities;
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


	}
