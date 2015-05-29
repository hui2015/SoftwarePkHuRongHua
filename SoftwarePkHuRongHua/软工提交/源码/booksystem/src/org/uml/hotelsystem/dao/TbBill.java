package org.uml.hotelsystem.dao;

import java.sql.Timestamp;

/**
 * TbBill entity. @author MyEclipse Persistence Tools
 */

public class TbBill implements java.io.Serializable {

	// Fields

	private Integer billId;
	private String billRoomType;
	private String billRoomName;
	private Double billRoomPrice;
	private Timestamp billStartTime;
	private Timestamp billEndTime;
	private Integer billCustomId;
	private String billCustomName;
	private String billCustomCardId;
	private String billCustomTele;
	private Integer billCreateAccountId;
	private String billCreateAccountName;
	private Double billTotalPrice;

	// Constructors

	/** default constructor */
	public TbBill() {
	}

	/** full constructor */
	public TbBill(String billRoomType, String billRoomName,
			Double billRoomPrice, Timestamp billStartTime,
			Timestamp billEndTime, Integer billCustomId, String billCustomName,
			String billCustomCardId, String billCustomTele,
			Integer billCreateAccountId, String billCreateAccountName,
			Double billTotalPrice) {
		this.billRoomType = billRoomType;
		this.billRoomName = billRoomName;
		this.billRoomPrice = billRoomPrice;
		this.billStartTime = billStartTime;
		this.billEndTime = billEndTime;
		this.billCustomId = billCustomId;
		this.billCustomName = billCustomName;
		this.billCustomCardId = billCustomCardId;
		this.billCustomTele = billCustomTele;
		this.billCreateAccountId = billCreateAccountId;
		this.billCreateAccountName = billCreateAccountName;
		this.billTotalPrice = billTotalPrice;
	}

	// Property accessors

	public Integer getBillId() {
		return this.billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getBillRoomType() {
		return this.billRoomType;
	}

	public void setBillRoomType(String billRoomType) {
		this.billRoomType = billRoomType;
	}

	public String getBillRoomName() {
		return this.billRoomName;
	}

	public void setBillRoomName(String billRoomName) {
		this.billRoomName = billRoomName;
	}

	public Double getBillRoomPrice() {
		return this.billRoomPrice;
	}

	public void setBillRoomPrice(Double billRoomPrice) {
		this.billRoomPrice = billRoomPrice;
	}

	public Timestamp getBillStartTime() {
		return this.billStartTime;
	}

	public void setBillStartTime(Timestamp billStartTime) {
		this.billStartTime = billStartTime;
	}

	public Timestamp getBillEndTime() {
		return this.billEndTime;
	}

	public void setBillEndTime(Timestamp billEndTime) {
		this.billEndTime = billEndTime;
	}

	public Integer getBillCustomId() {
		return this.billCustomId;
	}

	public void setBillCustomId(Integer billCustomId) {
		this.billCustomId = billCustomId;
	}

	public String getBillCustomName() {
		return this.billCustomName;
	}

	public void setBillCustomName(String billCustomName) {
		this.billCustomName = billCustomName;
	}

	public String getBillCustomCardId() {
		return this.billCustomCardId;
	}

	public void setBillCustomCardId(String billCustomCardId) {
		this.billCustomCardId = billCustomCardId;
	}

	public String getBillCustomTele() {
		return this.billCustomTele;
	}

	public void setBillCustomTele(String billCustomTele) {
		this.billCustomTele = billCustomTele;
	}

	public Integer getBillCreateAccountId() {
		return this.billCreateAccountId;
	}

	public void setBillCreateAccountId(Integer billCreateAccountId) {
		this.billCreateAccountId = billCreateAccountId;
	}

	public String getBillCreateAccountName() {
		return this.billCreateAccountName;
	}

	public void setBillCreateAccountName(String billCreateAccountName) {
		this.billCreateAccountName = billCreateAccountName;
	}

	public Double getBillTotalPrice() {
		return this.billTotalPrice;
	}

	public void setBillTotalPrice(Double billTotalPrice) {
		this.billTotalPrice = billTotalPrice;
	}

}