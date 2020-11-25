package tw.group4._04_.front.shopcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component("Shoppingcart")
public class Shoppingcart implements Serializable {
	
	private String MEMBERID;
	private String ORDERID;
	private String NAME;
	private String EMAIL;
	private String TEL;
	private String ADDRESS;
	private int ACT_ID;
	private String TITLE;	
	private String TICKETCATEGORY;
	private int TICKET_NUM;
	private int ADULT_NUM;
	private int HALF_NUM;
	private int TOTALPRICE;
	private String seatnum;
	private String seats[];


	public Shoppingcart(){
		
	}
	
	public String getMEMBERID() {
		return MEMBERID;
	}

	public void setMEMBERID(String mEMBERID) {
		MEMBERID = mEMBERID;
	}

	public String getORDERID() {
		return ORDERID;
	}
	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public int getACT_ID() {
		return ACT_ID;
	}
	public void setACT_ID(int actid) {
		ACT_ID = actid;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getTICKETCATEGORY() {
		return TICKETCATEGORY;
	}
	public void setTICKETCATEGORY(String tICKETCATEGORY) {
		TICKETCATEGORY = tICKETCATEGORY;
	}
	public int getADULT_NUM() {
		return ADULT_NUM;
	}
	public void setADULT_NUM(int aDULT_NUM) {
		ADULT_NUM = aDULT_NUM;
	}
	public int getHALF_NUM() {
		return HALF_NUM;
	}
	public void setHALF_NUM(int hALF_NUM) {
		HALF_NUM = hALF_NUM;
	}
	public int getTOTALPRICE() {
		return TOTALPRICE;
	}
	public void setTOTALPRICE(int tOTALPRICE) {
		TOTALPRICE = tOTALPRICE;
	}
	public String getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(String seatnum) {
		this.seatnum = seatnum;
	}
	
	public String[] getSeats() {
		return seats;
	}


	public void setSeats(String[] seats) {
		this.seats = seats;
	}
	
	public int getTICKET_NUM() {
		return TICKET_NUM;
	}


	public void setTICKET_NUM(int tICKET_NUM) {
		TICKET_NUM = tICKET_NUM;
	}
	
}
