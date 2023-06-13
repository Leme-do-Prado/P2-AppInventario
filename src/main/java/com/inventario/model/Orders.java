package com.inventario.model;

import java.util.Date;

public class Orders {
    private int ordNo;
    private int purchAmt;
    private Date ordDate;
    private int customerId;
    private int salesmanId;

    public Orders(int ordNo, int purchAmt, Date ordDate, int customerId, int salesmanId) {
        this.ordNo = ordNo;
        this.purchAmt = purchAmt;
        this.ordDate = ordDate;
        this.customerId = customerId;
        this.salesmanId = salesmanId;
    }

	public Orders() {
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int i) {
		this.ordNo = i;
	}

	public int getPurchAmt() {
		return purchAmt;
	}

	public void setPurchAmt(int purchAmt) {
		this.purchAmt = purchAmt;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date date) {
		this.ordDate = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
    
    
}
