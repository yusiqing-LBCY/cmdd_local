package cn.com.cmdd.domain;

import org.apache.ibatis.type.Alias;

@Alias("MemberIntegral")
public class MemberIntegral {

    private Integer shopId;
    private Double consumeMoney;
    private Double consumeIntegral;
    private Double convertMoney;
    private Double convertIntegral;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Double getConsumeMoney() {
        return consumeMoney;
    }

    public void setConsumeMoney(Double consumeMoney) {
        this.consumeMoney = consumeMoney;
    }

    public Double getConsumeIntegral() {
        return consumeIntegral;
    }

    public void setConsumeIntegral(Double consumeIntegral) {
        this.consumeIntegral = consumeIntegral;
    }

    public Double getConvertMoney() {
        return convertMoney;
    }

    public void setConvertMoney(Double convertMoney) {
        this.convertMoney = convertMoney;
    }

    public Double getConvertIntegral() {
        return convertIntegral;
    }

    public void setConvertIntegral(Double convertIntegral) {
        this.convertIntegral = convertIntegral;
    }
}
