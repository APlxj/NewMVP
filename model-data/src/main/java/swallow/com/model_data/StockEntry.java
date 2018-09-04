package swallow.com.model_data;

import java.util.List;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class StockEntry {

    private int stats;
    private String message;
    private int totalPage;
    private String main;
    private String others;
    private String totalPageList;
    private List<ListBean> list;

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getTotalPageList() {
        return totalPageList;
    }

    public void setTotalPageList(String totalPageList) {
        this.totalPageList = totalPageList;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {

        private String maxFlowId;
        private String flowId;
        private String merchantId;
        private String branchId;
        private String itemId;
        private double stockQty;
        private double costPrice;
        private double stockAmt;
        private double inTransitInQty;
        private String tSFlag;
        private String operType;
        private String itemName;
        private String tsflag;
        public String branchName = "";
        public String unitName = "";
        public String itemClsName = "";
        public String itemBarCode = "";
        public double depositNum;

        public String getMaxFlowId() {
            return maxFlowId;
        }

        public void setMaxFlowId(String maxFlowId) {
            this.maxFlowId = maxFlowId;
        }

        public String getFlowId() {
            return flowId;
        }

        public void setFlowId(String flowId) {
            this.flowId = flowId;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public double getStockQty() {
            return stockQty;
        }

        public void setStockQty(double stockQty) {
            this.stockQty = stockQty;
        }

        public double getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(double costPrice) {
            this.costPrice = costPrice;
        }

        public double getStockAmt() {
            return stockAmt;
        }

        public void setStockAmt(double stockAmt) {
            this.stockAmt = stockAmt;
        }

        public double getInTransitInQty() {
            return inTransitInQty;
        }

        public void setInTransitInQty(double inTransitInQty) {
            this.inTransitInQty = inTransitInQty;
        }

        public String getTSFlag() {
            return tSFlag;
        }

        public void setTSFlag(String tSFlag) {
            this.tSFlag = tSFlag;
        }

        public String getOperType() {
            return operType;
        }

        public void setOperType(String operType) {
            this.operType = operType;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getTsflag() {
            return tsflag;
        }

        public void setTsflag(String tsflag) {
            this.tsflag = tsflag;
        }

        public double getDepositNum() {
            return depositNum;
        }

        public void setDepositNum(double depositNum) {
            this.depositNum = depositNum;
        }
    }
}
