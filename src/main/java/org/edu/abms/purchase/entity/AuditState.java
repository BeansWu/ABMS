package org.edu.abms.purchase.entity;

/**
 * @Description: 审核状态
 * @author: 吴炳生
 * @date: 2017/7/8
 */
public enum AuditState {

    /** 保存但未提交 **/
    UNSUBMITTED(0),

    /** 已提交 **/
    SUBMITTED(1),

    /** 经办人已通过 **/
    MGR_AUDITED(2),
    
    /** 经办人已驳回 **/
    MGR_REJECT(3),

    /** 分管领导已审核 **/
    LD_AUDITED(4),
    
    /** 分管领导已驳回 **/
    LD_REJECT(5),

    /** 资产处已审核 **/
    ASSET_AUDITED(6),
    
    /** 资产处已驳回 **/
    ASSET_REJECT(7),
    
    /** 财务处已审核 **/
    FIN_AUDITED(8),
	
	/** 财务处已驳回 **/
    FIN_REJECT(9);

    

    private Byte val;

    private AuditState(Integer val) {
        this.val = val.byteValue();
    }

    public Byte getVal() {
        return val;
    }

    public int compare(AuditState auditState) {
        return compare(auditState);
    }

    public int compare(Byte auditState) {
        return this.val.compareTo(auditState);
    }
}
