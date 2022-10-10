package application.model;

import java.sql.Date;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class AbstractModel {
	private SimpleLongProperty id;
	private SimpleBooleanProperty deleted;
	private SimpleObjectProperty<Date> createdDate;
	private SimpleStringProperty createdBy;
	private SimpleObjectProperty<Date> updatedDate;
	private SimpleStringProperty updatedBy;
	public AbstractModel(Long id,boolean deleted,Date createdDate,String createdBy,Date updatedDate,String updatedBy) {
		this.id = new SimpleLongProperty(id);
		this.deleted = new SimpleBooleanProperty(deleted);
		this.createdDate = new SimpleObjectProperty<Date>(createdDate);
		this.updatedDate = new SimpleObjectProperty<Date>(updatedDate);
		this.createdBy = new SimpleStringProperty(createdBy);
		this.updatedBy = new SimpleStringProperty(updatedBy);
	}
	public Long getId() {
		return id.get();
	}

	public void setId(Long id) {
		this.id.set(id);
	}
	
	
	public boolean isDeleted() {
		return deleted.get();
	}

	public void setDeleted(boolean deleted) {
		this.deleted.set(deleted);
	}
	
	
	public Date getCreatedDate() {
		return createdDate.get();
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate.set(createdDate);
	}
	
	
	public String getCreatedBy() {
		return createdBy.get();
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy.set(createdBy);
	}
	
	
	public Date getUpdatedDate() {
		return updatedDate.get();
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate.set(updatedDate);
	}
	
	
	public String getUpdatedBy() {
		return updatedBy.get();
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy.set(updatedBy);
	}
	
	
	
	
}
