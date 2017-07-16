package org.edu.abms.purchase.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/** @Description:TODO 采购品目
 * @author: 吴忠恩
 * @date:   2017年7月10日 下午1:24:59
 */
@Component
@Entity
@Table(name = "t_purchase_item")
public class PurchaseItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 
	 * 主键，自增  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** 
	 * 编码 
	 */
	@Column(length = 45, nullable =false)
	private String code;
	
	/** 
	 * 品目名称
	 */
	@Column(length = 45, nullable =false)
	private String name;
	
	/**
	 * 金额起点
	 */
	@Column(name = "money_start", nullable = true)
	private Integer moneyStart;
	
	/**
	 * 说明
	 */
	@Column
	private String description;
	
	/** 
	 * 父类   
	 */
	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FATHER_ITEM_ID_FK"))
	private PurchaseItem parentItem;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getMoneyStart() {
		return moneyStart;
	}
	
	public void setMoneyStart(Integer moneyStart) {
		this.moneyStart = moneyStart;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public PurchaseItem getParentItem() {
		return parentItem;
	}

	public void setParentItem(PurchaseItem parentItem) {
		this.parentItem = parentItem;
	}
	
	public PurchaseItem() {
		super();
	}

	public PurchaseItem(String code, String name, Integer moneyStart, String description, PurchaseItem parentItem) {
		super();
		this.code = code;
		this.name = name;
		this.moneyStart = moneyStart;
		this.description = description;
		this.parentItem = parentItem;
	}

	public PurchaseItem(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	



}
