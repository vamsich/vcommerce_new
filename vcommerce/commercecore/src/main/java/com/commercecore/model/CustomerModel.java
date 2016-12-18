package com.commercecore.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class CustomerModel extends UserModel
{
	@Column
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<AddressModel> addresses;

	public Set<AddressModel> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressModel> addresses) {
		this.addresses = addresses;
	}
}
