package com.InventoryManagement.Model;

public class Item {

	private String Iname;
	private String Icode;
	private int Quantity;
	private double Price;
	
	
	
	public Item() {
		super();
	}
	public Item(String icode) {
		super();
		Icode = icode;
	}
	public String getIname() {
		return Iname;
	}
	public void setIname(String iname) {
		Iname = iname;
	}
	public String getIcode() {
		return Icode;
	}
	public void setIcode(String icode) {
		Icode = icode;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "Item [Iname=" + Iname + ", Icode=" + Icode + ", Quantity=" + Quantity + ", Price=" + Price + "]";
	}
	
	
	
	
}
