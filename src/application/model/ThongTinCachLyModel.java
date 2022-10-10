package application.model;

import java.sql.Date;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class ThongTinCachLyModel extends AbstractModel {
	private SimpleStringProperty ten;
	private SimpleObjectProperty<Date> thoiGianBatDau;
	private SimpleStringProperty mucDoCachLy;
	private SimpleBooleanProperty tested;
	public ThongTinCachLyModel(Long id, boolean deleted, Date createdDate, String createdBy, Date updatedDate,
			String updatedBy, String ten, Date thoiGianBatDau,
			String mucDoCachLy, boolean tested) {
		super(id, deleted, createdDate, createdBy, updatedDate, updatedBy);
		this.ten = new SimpleStringProperty(ten);
		this.thoiGianBatDau = new SimpleObjectProperty<Date>(thoiGianBatDau);
		this.mucDoCachLy = new SimpleStringProperty(mucDoCachLy);
		this.tested = new SimpleBooleanProperty(tested);
	}
	
	public boolean isTested() {
		return tested.get();
	}

	public void setTested(boolean tested) {
		this.tested.set(tested);
	}
	
	
	public Date getThoiGianBatDau() {
		return thoiGianBatDau.get();
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau.set(thoiGianBatDau);
	}
	public String getTen() {
		return ten.get();
	}

	public void setTen(String ten) {
		this.ten.set(ten);
	}
	public String getMucDoCachLy() {
		return mucDoCachLy.get();
	}

	public void setMucDoCachLy(String mucDoCachLy) {
		this.mucDoCachLy.set(mucDoCachLy);
	}
	

}
