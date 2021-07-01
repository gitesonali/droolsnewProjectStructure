package com.crystalrunhealthcare.eventrules.model;

public class Patient {
	private double age;
	private int annualwellnessdatePriorBy;
	private int annualphysicaldatePriorBy;
	private String categotyReason;
	private boolean hasPCP;
	private boolean concussion;
	private boolean establishedPatient;
	private String payer;
	private int proceduredatePriorBy;
	private String selectedEvent;
	private String selectedEventId;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(double age, int annualwellnessdatePriorBy, int annualphysicaldatePriorBy, String categotyReason,
			boolean hasPCP, boolean concussion, boolean establishedPatient, String payer, int proceduredatePriorBy,
			String selectedEvent, String selectedEventId) {
		super();
		this.age = age;
		this.annualwellnessdatePriorBy = annualwellnessdatePriorBy;
		this.annualphysicaldatePriorBy = annualphysicaldatePriorBy;
		this.categotyReason = categotyReason;
		this.hasPCP = hasPCP;
		this.concussion = concussion;
		this.establishedPatient = establishedPatient;
		this.payer = payer;
		this.proceduredatePriorBy = proceduredatePriorBy;
		this.selectedEvent = selectedEvent;
		this.selectedEventId = selectedEventId;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public int getAnnualwellnessdatePriorBy() {
		return annualwellnessdatePriorBy;
	}
	public void setAnnualwellnessdatePriorBy(int annualwellnessdatePriorBy) {
		this.annualwellnessdatePriorBy = annualwellnessdatePriorBy;
	}
	public int getAnnualphysicaldatePriorBy() {
		return annualphysicaldatePriorBy;
	}
	public void setAnnualphysicaldatePriorBy(int annualphysicaldatePriorBy) {
		this.annualphysicaldatePriorBy = annualphysicaldatePriorBy;
	}
	public String getCategotyReason() {
		return categotyReason;
	}
	public void setCategotyReason(String categotyReason) {
		this.categotyReason = categotyReason;
	}
	public boolean isHasPCP() {
		return hasPCP;
	}
	public void setHasPCP(boolean hasPCP) {
		this.hasPCP = hasPCP;
	}
	public boolean isConcussion() {
		return concussion;
	}
	public void setConcussion(boolean concussion) {
		this.concussion = concussion;
	}
	public boolean isEstablishedPatient() {
		return establishedPatient;
	}
	public void setEstablishedPatient(boolean establishedPatient) {
		this.establishedPatient = establishedPatient;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public int getProceduredatePriorBy() {
		return proceduredatePriorBy;
	}
	public void setProceduredatePriorBy(int proceduredatePriorBy) {
		this.proceduredatePriorBy = proceduredatePriorBy;
	}
	public String getSelectedEvent() {
		return selectedEvent;
	}
	public void setSelectedEvent(String selectedEvent) {
		this.selectedEvent = selectedEvent;
	}
	public String getSelectedEventId() {
		return selectedEventId;
	}
	public void setSelectedEventId(String selectedEventId) {
		this.selectedEventId = selectedEventId;
	}
	@Override
	public String toString() {
		return "Patient [age=" + age + ", annualwellnessdatePriorBy=" + annualwellnessdatePriorBy
				+ ", annualphysicaldatePriorBy=" + annualphysicaldatePriorBy + ", categotyReason=" + categotyReason
				+ ", hasPCP=" + hasPCP + ", concussion=" + concussion + ", establishedPatient=" + establishedPatient
				+ ", payer=" + payer + ", proceduredatePriorBy=" + proceduredatePriorBy + ", selectedEvent="
				+ selectedEvent + ", selectedEventId=" + selectedEventId + "]";
	}
	
}
