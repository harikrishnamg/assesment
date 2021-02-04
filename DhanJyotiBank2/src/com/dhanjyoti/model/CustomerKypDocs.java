package com.dhanjyoti.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="DHANJYOTI_CUSTOMER_UPLOAD")
public class CustomerKypDocs {
	@Id
	 @SequenceGenerator(name="customerDocSequence",sequenceName="CUSTOMER_DOC_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customerDocSequence")
	@Column(name="DOCUMENT_ID")
	private Integer documentID;
	@Column(name="FILE_NAME")
	private String fileName;
	@Column(name="NAME")
	private String docName;
	@Column(name="TYPE")
	private String docType;
	@Column(name="DESCRIPTION")
	private String docDescription;
	@Column(name="CONTENT")
	private byte[] docContent;
	@ManyToOne	
	@JoinColumn(name = "CUSTOMER_ID")
	private CustomerModel customer;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getDocumentID() {
		return documentID;
	}
	public void setDocumentID(Integer documentID) {
		this.documentID = documentID;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocDescription() {
		return docDescription;
	}
	public void setDocDescription(String docDescription) {
		this.docDescription = docDescription;
	}
	public byte[] getDocContent() {
		return docContent;
	}
	public void setDocContent(byte[] docContent) {
		this.docContent = docContent;
	}
	public CustomerModel getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	
	
	
	
}
