package org.uml.hotelsystem.dao;

/**
 * TbAccount entity. @author MyEclipse Persistence Tools
 */

public class TbAccount implements java.io.Serializable {

	// Fields

	private Integer accountId;
	private String accountUser;
	private String accountName;
	private String accountPassword;
	private Integer accountAuthority;
	private Boolean accountUsable;

	// Constructors

	/** default constructor */
	public TbAccount() {
	}

	/** full constructor */
	public TbAccount(String accountUser, String accountName,
			String accountPassword, Integer accountAuthority,
			Boolean accountUsable) {
		this.accountUser = accountUser;
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.accountAuthority = accountAuthority;
		this.accountUsable = accountUsable;
	}

	// Property accessors

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountUser() {
		return this.accountUser;
	}

	public void setAccountUser(String accountUser) {
		this.accountUser = accountUser;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return this.accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public Integer getAccountAuthority() {
		return this.accountAuthority;
	}

	public void setAccountAuthority(Integer accountAuthority) {
		this.accountAuthority = accountAuthority;
	}

	public Boolean getAccountUsable() {
		return this.accountUsable;
	}

	public void setAccountUsable(Boolean accountUsable) {
		this.accountUsable = accountUsable;
	}

}