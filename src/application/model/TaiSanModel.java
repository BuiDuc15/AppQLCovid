package application.model;

import java.sql.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TaiSanModel extends AbstractModel {
	
	private SimpleStringProperty ten;
	private SimpleStringProperty hienTrang;
	private SimpleIntegerProperty soLuong;
	
	
	
	


	public TaiSanModel(Long id, boolean deleted, Date createdDate, String createdBy, Date updatedDate, String updatedBy,
			String ten, String hienTrang, int soLuong) {
		super(id, deleted, createdDate, createdBy, updatedDate, updatedBy);
		this.ten = new SimpleStringProperty(ten);
		this.hienTrang = new SimpleStringProperty(hienTrang);
		this.soLuong = new SimpleIntegerProperty(soLuong);
	}

	public String getTen() {
		return ten.get();
	}

	public void setTen(String ten) {
		this.ten.set(ten);
	}
	
	
	public String getHienTrang() {
		return hienTrang.get();
	}

	public void setHienTrang(String hienTrang) {
		this.hienTrang.set(hienTrang);
	}
	
	public int getSoLuong() {
		return soLuong.get();
	}

	public void setSoLuong(int soLuong) {
		this.soLuong.set(soLuong);
	}

	@Override
	public String toString() {
		return "TaiSanModel [ten=" + ten + ", hienTrang=" + hienTrang + ", soLuong=" + soLuong + "]";
	}
	
	

}
