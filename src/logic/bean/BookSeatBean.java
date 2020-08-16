package logic.bean;

import logic.entity.Prenotazione;

public class BookSeatBean {
	private Prenotazione prenotazione;
	
	public BookSeatBean() {
	}
	
	public BookSeatBean(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

}
