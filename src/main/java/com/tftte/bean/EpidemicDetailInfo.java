package com.tftte.bean;

/**
 * @Author: tftte
 * @Date: 2020/8/2 21:05
 * @Description: 累计信息统计
 */
public class EpidemicDetailInfo extends EpidemicInfo {

    private String provinceName;

    // 累计的
    private Integer affirmedTotal, suspectedTotal, curedTotal, isolatedTotal, deadTotal;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getAffirmedTotal() {
        return affirmedTotal;
    }

    public void setAffirmedTotal(Integer affirmedTotal) {
        this.affirmedTotal = affirmedTotal;
    }

    public Integer getSuspectedTotal() {
        return suspectedTotal;
    }

    public void setSuspectedTotal(Integer suspectedTotal) {
        this.suspectedTotal = suspectedTotal;
    }

    public Integer getCuredTotal() {
        return curedTotal;
    }

    public void setCuredTotal(Integer curedTotal) {
        this.curedTotal = curedTotal;
    }

    public Integer getIsolatedTotal() {
        return isolatedTotal;
    }

    public void setIsolatedTotal(Integer isolatedTotal) {
        this.isolatedTotal = isolatedTotal;
    }

    public Integer getDeadTotal() {
        return deadTotal;
    }

    public void setDeadTotal(Integer deadTotal) {
        this.deadTotal = deadTotal;
    }
}
