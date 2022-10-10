package application.model;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
	private static Singleton instance;
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
	private TaiSanModel model;
	private List<TaiSanModel> list;
	private HoatDongModel model1;
	private List<HoatDongModel> list1;
	private DangKyModel model2;
	private List<DangKyModel> list2;
	private KhaiBaoDichTeModel model3;
	List<KhaiBaoDichTeModel> list3;
	private ThongTinCachLyModel model4;
	List<ThongTinCachLyModel> list4;
	public TaiSanModel getModel() {
		return model;
	}
	public void setModel(TaiSanModel model) {
		this.model = model;
	}
	public List<TaiSanModel> getList() {
		return list;
	}
	public void setList(List<TaiSanModel> list) {
		this.list = list;
	}
	public HoatDongModel getModel1() {
		return model1;
	}
	public void setModel1(HoatDongModel model1) {
		this.model1 = model1;
	}
	public List<HoatDongModel> getList1() {
		return list1;
	}
	public void setList1(List<HoatDongModel> list1) {
		this.list1 = list1;
	}
	public DangKyModel getModel2() {
		return model2;
	}
	public void setModel2(DangKyModel model2) {
		this.model2 = model2;
	}
	public List<DangKyModel> getList2() {
		return list2;
	}
	public void setList2(List<DangKyModel> list2) {
		this.list2 = list2;
	}
	public KhaiBaoDichTeModel getModel3() {
		return model3;
	}
	public void setModel3(KhaiBaoDichTeModel model3) {
		this.model3 = model3;
	}
	public List<KhaiBaoDichTeModel> getList3() {
		return list3;
	}
	public void setList3(List<KhaiBaoDichTeModel> list3) {
		this.list3 = list3;
	}
	public ThongTinCachLyModel getModel4() {
		return model4;
	}
	public void setModel4(ThongTinCachLyModel model4) {
		this.model4 = model4;
	}
	public List<ThongTinCachLyModel> getList4() {
		return list4;
	}
	public void setList4(List<ThongTinCachLyModel> list4) {
		this.list4 = list4;
	}
	
	
	
	
}
