package org.uml.hotelsystem.dao;

import java.sql.Timestamp;

/**
 * TbConsume entity. @author MyEclipse Persistence Tools
 */

public class TbConsume implements java.io.Serializable {

	// Fields

	private Integer consumeId;
	private Integer consumeLiveinId;
	private Integer consumeGoodId;
	private Integer consumeCount;
	private Double consumeTotalPrice;
	private Timestamp consumeTime;

	// Constructors

	/** default constructor */
	public TbConsume() {
	}

	/** full constructor */
	public TbConsume(Integer consumeLiveinId, Integer consumeGoodId,
			Integer consumeCount, Double consumeTotalPrice,
			Timestamp consumeTime) {
		this.consumeLiveinId = consumeLiveinId;
		this.consumeGoodId = consumeGoodId;
		this.consumeCount = consumeCount;
		this.consumeTotalPrice = consumeTotalPrice;
		this.consumeTime = consumeTime;
	}

	// Property accessors

	public Integer getConsumeId() {
		return this.consumeId;
	}

	public void setConsumeId(Integer consumeId) {
		this.consumeId = consumeId;
	}

	public Integer getConsumeLiveinId() {
		return this.consumeLiveinId;
	}

	public void setConsumeLiveinId(Integer consumeLiveinId) {
		this.consumeLiveinId = consumeLiveinId;
	}

	public Integer getConsumeGoodId() {
		return this.consumeGoodId;
	}

	public void setConsumeGoodId(Integer consumeGoodId) {
		this.consumeGoodId = consumeGoodId;
	}

	public Integer getConsumeCount() {
		return this.consumeCount;
	}

	public void setConsumeCount(Integer consumeCount) {
		this.consumeCount = consumeCount;
	}

	public Double getConsumeTotalPrice() {
		return this.consumeTotalPrice;
	}

	public void setConsumeTotalPrice(Double consumeTotalPrice) {
		this.consumeTotalPrice = consumeTotalPrice;
	}

	public Timestamp getConsumeTime() {
		return this.consumeTime;
	}

	public void setConsumeTime(Timestamp consumeTime) {
		this.consumeTime = consumeTime;
	}

}