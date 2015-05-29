package org.uml.hotelsystem.dao;

/**
 * TbCustom entity. @author MyEclipse Persistence Tools
 */

public class TbCustom implements java.io.Serializable {

	// Fields

	private Integer customId;
	private String customName;
	private String customIdCardNum;
	private String customTeleNum;

	// Constructors

	/** default constructor */
	public TbCustom() {
	}

	/** full constructor */
	public TbCustom(String customName, String customIdCardNum,
			String customTeleNum) {
		this.customName = customName;
		this.customIdCardNum = customIdCardNum;
		this.customTeleNum = customTeleNum;
	}

	// Property accessors

	public Integer getCustomId() {
		return this.customId;
	}

	public void setCustomId(Integer customId) {
		this.customId = customId;
	}

	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getCustomIdCardNum() {
		return this.customIdCardNum;
	}

	public void setCustomIdCardNum(String customIdCardNum) {
		this.customIdCardNum = customIdCardNum;
	}

	public String getCustomTeleNum() {
		return this.customTeleNum;
	}

	public void setCustomTeleNum(String customTeleNum) {
		this.customTeleNum = customTeleNum;
	}

}