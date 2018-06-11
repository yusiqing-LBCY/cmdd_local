package cn.com.cmdd.domain;



import java.util.ArrayList;
import java.util.List;

public class UnifyOrder {
    private Integer shopId;
    private Integer diningTablePid;
    private ArrayList<Integer> diningTableIdList;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getDiningTablePid() {
        return diningTablePid;
    }

    public void setDiningTablePid(Integer diningTablePid) {
        this.diningTablePid = diningTablePid;
    }

    public ArrayList<Integer> getDiningTableIdList() {
        return diningTableIdList;
    }

    public void setDiningTableIdList(ArrayList<Integer> diningTableIdList) {
        this.diningTableIdList = diningTableIdList;
    }
}
