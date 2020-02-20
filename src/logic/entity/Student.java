package logic.entity;

import logic.pattern.BannedState;
import logic.pattern.NormalState;
import logic.pattern.NotifiedState;
import logic.pattern.StateMachine;

public class Student extends User {

	private boolean isBanned;
	private byte reportCounter;
	private String surname;
	private StateMachine stateMachine;

	public Student() {
		this.stateMachine = new StateMachine(NormalState.getInstance());

	}

	public Student(String namep, String surnamep, String userNameP, String mailp, String passwordp, boolean isBanned,
			byte reportCounter) {

		this.name = namep;
		this.surname = surnamep;
		this.mail = mailp;
		this.password = passwordp;
		this.userName = userNameP;
		this.isBanned = isBanned;
		this.reportCounter = reportCounter;
		if ((reportCounter > 2) && (!isBanned))
			this.stateMachine = new StateMachine(NotifiedState.getInstance());
		else if (isBanned)
			this.stateMachine = new StateMachine(BannedState.getInstance());
		this.stateMachine = new StateMachine(NormalState.getInstance());
	}

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	public byte getReportCounter() {
		return reportCounter;
	}

	public void setReportCounter(byte reportCounter) {
		this.reportCounter = reportCounter;
	}

	public void increaseReportCounter() {
		this.reportCounter++;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void fillStudent(String surname, boolean isBanned, byte reportCounter) {
		this.isBanned = isBanned;
		this.surname = surname;
		this.reportCounter = reportCounter;
	}

	public StateMachine getStateMachine() {
		return stateMachine;
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

}
