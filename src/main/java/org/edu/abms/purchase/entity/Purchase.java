package org.edu.abms.purchase.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.edu.abms.budget.entity.BudgetApp;
import org.edu.abms.common.entity.AuditState;
import org.springframework.stereotype.Component;

/** @Description:TODO 采购项目明细  
 * @author: 吴忠恩
 * @date:   2017年7月10日 下午1:24:09
 */
@Component
@Entity
@Table(name = "t_purchase")
public class Purchase implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 
	 * 主键，自增   
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** 
	 * 预算申请
	 */
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = BudgetApp.class)
	@JoinColumn(name="budget_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "BUDGET_APP_ID_FK"))
	private BudgetApp budgetApp;
	
	/** 
	 * 采购品目  
	 */
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = PurchaseItem.class)
	@JoinColumn(name = "item_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PURCHASE_ITEM_ID_FK"))
	private PurchaseItem purchaseItem;
	
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
	 * 是否属于政府采购预算编制范围 
	 */
	@Column(name = "is_purchase", nullable = false)
	private Boolean isPurchase = false;
	
	/** 
	 * 是否属于政府购买服务预算编制范围  
	 */
	@Column(name = "is_service", nullable = false)
	private Boolean isService = false;
	
	/** 
	 * 是否属于资产购置预算编制范围   
	 */
	@Column(name = "is_asset", nullable = false)
	private Boolean isAsset = false;
	
	/** 
	 * 是否专门面向中小企业（含监狱企业）   
	 */
	@Column(name = "is_face_middle", nullable = false)
	private Boolean isFaceMiddle;

	/**
	 * 审核状态
	 */
	private AuditState auditState;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BudgetApp getBudgetApp() {
		return budgetApp;
	}

	public void setBudgetApp(BudgetApp budgetApp) {
		this.budgetApp = budgetApp;
	}

	public PurchaseItem getPurchaseItem() {
		return purchaseItem;
	}

	public void setPurchaseItem(PurchaseItem purchaseItem) {
		this.purchaseItem = purchaseItem;
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

	public Boolean getIsPurchase() {
		return isPurchase;
	}

	public void setIsPurchase(Boolean isPurchase) {
		this.isPurchase = isPurchase;
	}

	public Boolean getIsService() {
		return isService;
	}

	public void setIsService(Boolean isService) {
		this.isService = isService;
	}

	public Boolean getIsAsset() {
		return isAsset;
	}

	public void setIsAsset(Boolean isAsset) {
		this.isAsset = isAsset;
	}

	public Boolean getIsFaceMiddle() {
		return isFaceMiddle;
	}

	public void setIsFaceMiddle(Boolean isFaceMiddle) {
		this.isFaceMiddle = isFaceMiddle;
	}
	
	public AuditState getAuditState() {
		return auditState;
	}

	public void setAuditState(AuditState auditState) {
		this.auditState = auditState;
	}

	public Purchase() {
		super();
	}

	public Purchase(BudgetApp budgetApp, PurchaseItem purchaseItem,
			Integer count, String unit, Integer price, Boolean isPurchase,
			Boolean isService, Boolean isAsset, Boolean isFaceMiddle) {
		super();
		this.budgetApp = budgetApp;
		this.purchaseItem = purchaseItem;
		this.count = count;
		this.unit = unit;
		this.price = price;
		this.isPurchase = isPurchase;
		this.isService = isService;
		this.isAsset = isAsset;
		this.isFaceMiddle = isFaceMiddle;
	}

	public Purchase(Integer id, PurchaseItem purchaseItem,
			Integer count, String unit, Integer price, Boolean isPurchase,
			Boolean isService, Boolean isAsset, Boolean isFaceMiddle) {
		super();
		this.id = id;
		this.purchaseItem = purchaseItem;
		this.count = count;
		this.unit = unit;
		this.price = price;
		this.isPurchase = isPurchase;
		this.isService = isService;
		this.isAsset = isAsset;
		this.isFaceMiddle = isFaceMiddle;
	}
	
	
}
