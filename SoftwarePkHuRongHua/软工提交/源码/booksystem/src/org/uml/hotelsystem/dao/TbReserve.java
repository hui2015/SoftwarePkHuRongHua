package org.uml.hotelsystem.dao;

import java.sql.Timestamp;

/**
 * TbReserve entity. @author MyEclipse Persistence Tools
 */

public class TbReserve implements java.io.Serializable {

	// Fields

	private Integer reserveId;
	private Integer reserveRoomId;
	private Timestamp reserveStartTime;
	private Timestamp reserveEndTime;
	private Integer reserveCustomId;
	private Integer reserveCreateAccountId;

	// Constructors

	/** default constructor */
	public TbReserve() {
	}

	/** full constructor */
	public TbReserve(Integer reserveRoomId, Timestamp reserveStartTime,
			Timestamp reserveEndTime, Integer reserveCustomId,
			Integer reserveCreateAccountId) {
		this.reserveRoomId = reserveRoomId;
		this.reserveStartTime = reserveStartTime;
		this.reserveEndTime = reserveEndTime;
		this.reserveCustomId = reserveCustomId;
		this.reserveCreateAccountId = reserveCreateAccountId;
	}

	// Property accessors

	public Integer getReserveId() {
		return this.reserveId;
	}

	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
	}

	public Integer getReserveRoomId() {
		return this.reserveRoomId;
	}

	public void setReserveRoomId(Integer reserveRoomId) {
		this.reserveRoomId = reserveRoomId;
	}

	public Timestamp getReserveStartTime() {
		return this.reserveStartTime;
	}

	public void setReserveStartTime(Timestamp reserveStartTime) {
		this.reserveStartTime = reserveStartTime;
	}

	public Timestamp getReserveEndTime() {
		return this.reserveEndTime;
	}

	public void setReserveEndTime(Timestamp reserveEndTime) {
		this.reserveEndTime = reserveEndTime;
	}

	public Integer getReserveCustomId() {
		return this.reserveCustomId;
	}

	public void setReserveCustomId(Integer reserveCustomId) {
		this.reserveCustomId = reserveCustomId;
	}

	public Integer getReserveCreateAccountId() {
		return this.reserveCreateAccountId;
	}

	public void setReserveCreateAccountId(Integer reserveCreateAccountId) {
		this.reserveCreateAccountId = reserveCreateAccountId;
	}

}