package org.uml.hotelsystem.dao;

import java.sql.Timestamp;

/**
 * TbLivein entity. @author MyEclipse Persistence Tools
 */

public class TbLivein implements java.io.Serializable {

	// Fields

	private Integer liveinId;
	private Integer liveinCustomId;
	private Integer liveinRoomId;
	private Timestamp liveinStartTime;
	private Timestamp liveinEndTime;
	private Integer liveinCreateAccountId;

	// Constructors

	/** default constructor */
	public TbLivein() {
	}

	/** full constructor */
	public TbLivein(Integer liveinCustomId, Integer liveinRoomId,
			Timestamp liveinStartTime, Timestamp liveinEndTime,
			Integer liveinCreateAccountId) {
		this.liveinCustomId = liveinCustomId;
		this.liveinRoomId = liveinRoomId;
		this.liveinStartTime = liveinStartTime;
		this.liveinEndTime = liveinEndTime;
		this.liveinCreateAccountId = liveinCreateAccountId;
	}

	// Property accessors

	public Integer getLiveinId() {
		return this.liveinId;
	}

	public void setLiveinId(Integer liveinId) {
		this.liveinId = liveinId;
	}

	public Integer getLiveinCustomId() {
		return this.liveinCustomId;
	}

	public void setLiveinCustomId(Integer liveinCustomId) {
		this.liveinCustomId = liveinCustomId;
	}

	public Integer getLiveinRoomId() {
		return this.liveinRoomId;
	}

	public void setLiveinRoomId(Integer liveinRoomId) {
		this.liveinRoomId = liveinRoomId;
	}

	public Timestamp getLiveinStartTime() {
		return this.liveinStartTime;
	}

	public void setLiveinStartTime(Timestamp liveinStartTime) {
		this.liveinStartTime = liveinStartTime;
	}

	public Timestamp getLiveinEndTime() {
		return this.liveinEndTime;
	}

	public void setLiveinEndTime(Timestamp liveinEndTime) {
		this.liveinEndTime = liveinEndTime;
	}

	public Integer getLiveinCreateAccountId() {
		return this.liveinCreateAccountId;
	}

	public void setLiveinCreateAccountId(Integer liveinCreateAccountId) {
		this.liveinCreateAccountId = liveinCreateAccountId;
	}

}