package org.edu.abms.subscribe.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.edu.abms.common.entity.AuditState;
import org.edu.abms.purchase.entity.Purchase;
import org.edu.abms.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Description:申购 entity
 * @author 吴忠恩
 * @date: 2017年7月28日
 */

@Component
@Entity
@Table(name = "t_subscribe")
public class Subscribe implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键，自增
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 申购人
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "USER_ID_FK2"))
	private User user;
	
	/**
	 * 货物名称
	 */
	@Column(length = 45, nullable = false)
	private String name;
	
	/**
	 * 资金来源
	 */
	@ManyToOne
	@JoinColumn(name = "purchase_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PURCHASE_ID_FK"))
	private Purchase purchase;
	
	/** 
	 * 数量
	 */
	@Column(nullable = false)
	private Integer count;
	
	/** 
	 * 计量单位  
	 */
	@Column(length = 5, nullable = false)
	private String unit;
	
	/** 
	 * 单价  
	 */
	@Column(nullable = false)
	private Integer price;
	
	/**
	 * 需求时间
	 */
	@Column(name = "required_time", length = 5, nullable = false)
	private Date requiredTime;
	
	/**
	 * 是否属于进口产品
	 */
	@Column(name = "is_imports", nullable = false)
	private Boolean isImports;
		
	/**
	 * 主要技术参数及售后服务要求
	 */
	@Column(name="param_and_require", length = 100)
	private String paramAndRequire;
	
	/**
	 * 审核状态，默认为未提交
	 */
	@Column(name = "audit_state", length = 2, nullable = false)
	private AuditState auditState = AuditState.UNSUBMITTED;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getRequiredTime() {
		return requiredTime;
	}

	public void setRequiredTime(Date requiredTime) {
		this.requiredTime = requiredTime;
	}

	public Boolean getIsImports() {
		return isImports;
	}

	public void setIsImports(Boolean isImports) {
		this.isImports = isImports;
	}

	public String getParamAndRequire() {
		return paramAndRequire;
	}

	public void setParamAndRequire(String paramAndRequire) {
		this.paramAndRequire = paramAndRequire;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AuditState getAuditState() {
		return auditState;
	}

	public void setAuditState(AuditState auditState) {
		this.auditState = auditState;
	}
	
	

	public Subscribe() {
		super();
	}

	public Subscribe(User user, String name, Purchase purchase, Integer count, String unit, Integer price,
			Date requiredTime, Boolean isImports, String paramAndRequire, AuditState auditState) {
		super();
		this.user = user;
		this.name = name;
		this.purchase = purchase;
		this.count = count;
		this.unit = unit;
		this.price = price;
		this.requiredTime = requiredTime;
		this.isImports = isImports;
		this.paramAndRequire = paramAndRequire;
		this.auditState = auditState;
	}

	

	

	


	
}
