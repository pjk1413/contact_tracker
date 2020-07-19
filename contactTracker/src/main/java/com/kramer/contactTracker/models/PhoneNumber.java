package com.kramer.contactTracker.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kramer.contactTracker.enums.NumberType;

@Entity
public class PhoneNumber {

	@Id
	@GeneratedValue
	@Column(name = "phone_id")
	private Long id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "type")
	private NumberType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id", nullable = false)
	private Contact contact;
	
	// -------------------- CONSTRUCTOR
	
	public PhoneNumber() {}

	// -------------------- GETTERS AND SETTERS -------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public NumberType getType() {
		return type;
	}

	public void setType(NumberType type) {
		this.type = type;
	}

	@JsonIgnore
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", number=" + number + ", type=" + type + ", contact=" + contact + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
	
}
