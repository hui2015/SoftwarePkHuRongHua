package org.uml.hotelsystem.dao;

/**
 * TbGood entity. @author MyEclipse Persistence Tools
 */

public class TbGood implements java.io.Serializable {

	// Fields

	private Integer goodId;
	private String goodName;
	private Double goodPrice;
	private Integer goodUseable;

	// Constructors

	/** default constructor */
	public TbGood() {
	}

	/** minimal constructor */
	public TbGood(Integer goodUseable) {
		this.goodUseable = goodUseable;
	}

	/** full constructor */
	public TbGood(String goodName, Double goodPrice, Integer goodUseable) {
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodUseable = goodUseable;
	}

	// Property accessors

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return this.goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public Double getGoodPrice() {
		return this.goodPrice;
	}

	public void setGoodPrice(Double goodPrice) {
		this.goodPrice = goodPrice;
	}

	public Integer getGoodUseable() {
		return this.goodUseable;
	}

	public void setGoodUseable(Integer goodUseable) {
		this.goodUseable = goodUseable;
	}

}