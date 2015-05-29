package org.uml.hotelsystem.dao;

/**
 * TbRoom entity. @author MyEclipse Persistence Tools
 */

public class TbRoom implements java.io.Serializable {

	// Fields

	private Integer roomId;
	private String roomName;
	private Integer roomType;
	private Long roomPrice;
	private Integer roomUseable;
	private Integer roomCurState;

	// Constructors

	/** default constructor */
	public TbRoom() {
	}

	/** minimal constructor */
	public TbRoom(Integer roomType, Long roomPrice, Integer roomUseable,
			Integer roomCurState) {
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomUseable = roomUseable;
		this.roomCurState = roomCurState;
	}

	/** full constructor */
	public TbRoom(String roomName, Integer roomType, Long roomPrice,
			Integer roomUseable, Integer roomCurState) {
		this.roomName = roomName;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomUseable = roomUseable;
		this.roomCurState = roomCurState;
	}

	// Property accessors

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getRoomType() {
		return this.roomType;
	}

	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}

	public Long getRoomPrice() {
		return this.roomPrice;
	}

	public void setRoomPrice(Long roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Integer getRoomUseable() {
		return this.roomUseable;
	}

	public void setRoomUseable(Integer roomUseable) {
		this.roomUseable = roomUseable;
	}

	public Integer getRoomCurState() {
		return this.roomCurState;
	}

	public void setRoomCurState(Integer roomCurState) {
		this.roomCurState = roomCurState;
	}

}