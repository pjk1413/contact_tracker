package com.kramer.contactTracker.models;

import java.util.Date;

import javax.persistence.*;

import com.kramer.contactTracker.enums.EventType;

@Entity
public class Event {

	@Id
	@GeneratedValue
	@Column(name = "event_id")
	private Long id;
	
	@Column(name = "event_type")
	private EventType type;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "remind")
	private Boolean remind;
	
	@Column(name = "notes")
	private String notes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id", nullable = false)
	private Contact contact;
	
	
	// ------------------------------------ CONSTRUCTOR ------------------------------
	
	public Event() {}

	// ------------------------------------ GETTERS AND SETTERS ----------------------
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public EventType getType() {
		return type;
	}


	public void setType(EventType type) {
		this.type = type;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Boolean getRemind() {
		return remind;
	}


	public void setRemind(Boolean remind) {
		this.remind = remind;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", type=" + type + ", date=" + date + ", remind=" + remind + ", notes=" + notes
				+ ", contact=" + contact + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((remind == null) ? 0 : remind.hashCode());
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
		Event other = (Event) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (remind == null) {
			if (other.remind != null)
				return false;
		} else if (!remind.equals(other.remind))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	
	
	
}
