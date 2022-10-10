package application.model;

import java.sql.Date;

import javafx.beans.property.SimpleStringProperty;

public class KhaiBaoDichTeModel extends AbstractModel {
	private SimpleStringProperty ten;
	private SimpleStringProperty trangThaiSucKhoe;
	public KhaiBaoDichTeModel(Long id, boolean deleted, Date createdDate, String createdBy, Date updatedDate,
			String updatedBy, String ten, String trangThaiSucKhoe) {
		super(id, deleted, createdDate, createdBy, updatedDate, updatedBy);
		this.ten = new SimpleStringProperty(ten);
		this.trangThaiSucKhoe = new SimpleStringProperty(trangThaiSucKhoe);
	}
	public String getTen() {
		return ten.get();
	}

	public void setTen(String ten) {
		this.ten.set(ten);
	}
	public String getTrangThaiSucKhoe() {
		return trangThaiSucKhoe.get();
	}

	public void setTrangThaiSucKhoe(String trangThaiSucKhoe) {
		this.trangThaiSucKhoe.set(trangThaiSucKhoe);
	}
	
	
	
}
