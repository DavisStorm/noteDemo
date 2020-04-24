package com.davis.mall.bean;

/**
 * @author 王阳
 * @time 2019/11/9  1:56
 * @desc
 */
public class ShouYeCategoryBean extends BaseArrayObjectEntity<ShouYeCategoryBean.DataList>{

    public class DataList{

        /**
         * allowPartition : false
         * expression : null
         * id : 3
         * isLeaf : false
         * logo : http://xqproduct.xiangqu.com/FgIX-veWk2Ae4ewnYPSqv8rfTt6G?imageView2/2/w/100/q/90/format/jpg/150x150/
         * name : 生活家居
         * orderNum : 6
         * orderScript :
         * orderType : INTEGRAL
         * parentId : 0
         * randomResult : true
         * status : ENABLE
         */

        private boolean allowPartition;
        private Object expression;
        private int id;
        private boolean isLeaf;
        private String logo;
        private String name;
        private int orderNum;
        private String orderScript;
        private String orderType;
        private int parentId;
        private boolean randomResult;
        private String status;

        public boolean isAllowPartition() {
            return allowPartition;
        }

        public void setAllowPartition(boolean allowPartition) {
            this.allowPartition = allowPartition;
        }

        public Object getExpression() {
            return expression;
        }

        public void setExpression(Object expression) {
            this.expression = expression;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIsLeaf() {
            return isLeaf;
        }

        public void setIsLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public String getOrderScript() {
            return orderScript;
        }

        public void setOrderScript(String orderScript) {
            this.orderScript = orderScript;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public boolean isRandomResult() {
            return randomResult;
        }

        public void setRandomResult(boolean randomResult) {
            this.randomResult = randomResult;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
