package application.model;

import java.sql.Date;

import javafx.beans.property.SimpleStringProperty;

public class HoatDongModel extends AbstractModel{
	
	private SimpleStringProperty ten;

	public HoatDongModel(Long id, boolean deleted, Date createdDate, String createdBy, Date updatedDate,
			String updatedBy, String ten) {
		super(id, deleted, createdDate, createdBy, updatedDate, updatedBy);
		this.ten = new SimpleStringProperty(ten);
	}

	public String getTen() {
		return ten.get();
	}

	public void setTen(String ten) {
		this.ten.set(ten);
	}
	
}
