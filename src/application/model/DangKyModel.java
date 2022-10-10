package application.model;

import java.sql.Date;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class DangKyModel extends AbstractModel {
	private SimpleStringProperty ten;
	private SimpleStringProperty tenNguoiDangKy;
	private SimpleFloatProperty phi;
	private SimpleStringProperty soDienThoai;
	public DangKyModel(Long id, boolean deleted, Date createdDate, String createdBy, Date updatedDate, String updatedBy,
			String ten, String tenNguoiDangKy, float phi,
			String soDienThoai) {
		super(id, deleted, createdDate, createdBy, updatedDate, updatedBy);
		this.ten = new SimpleStringProperty(ten);
		this.tenNguoiDangKy = new SimpleStringProperty(tenNguoiDangKy);
		this.phi = new SimpleFloatProperty(phi);
		this.soDienThoai = new SimpleStringProperty(soDienThoai);	
	}
	public String getTen() {
		return ten.get();
	}

	public void setTen(String ten) {
		this.ten.set(ten);
	}
	
	public String getTenNguoiDangKy() {
		return tenNguoiDangKy.get();
	}

	public void setTenNguoiDangKy(String tenNguoiDangKy) {
		this.tenNguoiDangKy.set(tenNguoiDangKy);
	}
	public float getPhi() {
		return phi.get();
	}

	public void setPhi(float phi) {
		this.phi.set(phi);
	}
	public String getSoDienThoai() {
		return soDienThoai.get();
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai.set(soDienThoai);
	}
	

}
