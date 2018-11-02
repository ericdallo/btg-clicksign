package com.ericdallo.btgclicksign.signer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "signer")
@Immutable
public class Signer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "`key`", nullable = false, unique = true, length = 60)
	private String key;
	
	@Column(name = "name", nullable = false,  unique = true, length = 80)
	private String name;
	
	@Column(name = "sign_type", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private SignType type;
	
	public Long getId() {
		return id;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getName() {
		return name;
	}
	
	public SignType getType() {
		return type;
	}
	
}
