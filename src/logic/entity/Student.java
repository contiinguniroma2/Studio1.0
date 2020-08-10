package logic.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import logic.pattern.BannedState;
import logic.pattern.NormalState;
import logic.pattern.NotifiedState;
import logic.pattern.StateMachine;

public class Student extends User {

	private boolean isBanned;
	private byte reportCounter;
	private String surname;
	private StateMachine stateMachine;
	private Prenotazione prenotazione;
	private Message message;
	private LocalDateTime time;

	public Student() {
		this.stateMachine = new StateMachine(new NormalState());

	}

	public Student(String name, String surname, String userName, String mail, String password, boolean isBanned,
			byte reportCounter, String time) {

		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.userName = userName;
		this.isBanned = isBanned;
		this.reportCounter = reportCounter;
		if ((reportCounter > 2) && (!isBanned)) {
			this.stateMachine = new StateMachine(new NotifiedState());
		}
		else if (isBanned) {
			this.stateMachine = new StateMachine(new BannedState());
		}
		else {
		    this.stateMachine = new StateMachine(new NormalState());
		}
		if (time.equals("")) {
			this.time = null;
		}
		else {
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
			this.time = LocalDateTime.parse(time, formatter);
			Duration duration = Duration.between(this.time, LocalDateTime.now());
			if (duration.getSeconds()>172800 && this.isBanned!=true) {
				 this.setBanned(true);
				 this.stateMachine.setState(new BannedState());
			}
			else {
				this.stateMachine.setState(new NotifiedState());
			}
		}
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
	
	public void startCountdown() {
		time = LocalDateTime.now();
	}
	
	public void stopCountdown() {
		time = null;
	}

	public String getCountdown() {
		if (time == null) {
			return "";
		}
		return time.toString();
	}
	
}
