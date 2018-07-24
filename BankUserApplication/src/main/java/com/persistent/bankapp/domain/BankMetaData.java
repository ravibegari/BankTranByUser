package com.persistent.bankapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_bank_metadata")
public class BankMetaData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="seq_no",nullable=false,updatable=false)
	private Long seqNo;
	private String message;
	public Long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
