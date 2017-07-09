package org.edu.abms.budget.entity;

/**
 * @Description: 审核状态
 * @author: 吴炳生
 * @date: 2017/7/8
 */
public enum AuditState {
    /** 已驳回 **/
    DISMISSED(-5),

    /** 保存但未提交 **/
    UNSUBMITTED(0),

    /** 已提交 **/
    SUBMITTED(5),

    /** 经办人已审核 **/
    MGR_AUDITED(10),

    /** 分管领导已审核 **/
    LD_AUDITED(15),

    /** 财务处已审核 **/
    FIN_AUDITED(20),

    /** 资产处已审核 **/
    ASSET_AUDITED(25);

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
