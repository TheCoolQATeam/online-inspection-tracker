package com.onlines.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OnlinesPatrolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OnlinesPatrolExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoIsNull() {
            addCriterion("htmlinfo is null");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoIsNotNull() {
            addCriterion("htmlinfo is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoEqualTo(String value) {
            addCriterion("htmlinfo =", value, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoNotEqualTo(String value) {
            addCriterion("htmlinfo <>", value, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoGreaterThan(String value) {
            addCriterion("htmlinfo >", value, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoGreaterThanOrEqualTo(String value) {
            addCriterion("htmlinfo >=", value, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoLessThan(String value) {
            addCriterion("htmlinfo <", value, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoLessThanOrEqualTo(String value) {
            addCriterion("htmlinfo <=", value, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoLike(String value) {
            addCriterion("htmlinfo like", value, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoNotLike(String value) {
            addCriterion("htmlinfo not like", value, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoIn(List<String> values) {
            addCriterion("htmlinfo in", values, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoNotIn(List<String> values) {
            addCriterion("htmlinfo not in", values, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoBetween(String value1, String value2) {
            addCriterion("htmlinfo between", value1, value2, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andHtmlinfoNotBetween(String value1, String value2) {
            addCriterion("htmlinfo not between", value1, value2, "htmlinfo");
            return (Criteria) this;
        }

        public Criteria andGroupIsNull() {
            addCriterion("`groupId` is null");
            return (Criteria) this;
        }

        public Criteria andGroupIsNotNull() {
            addCriterion("`groupId` is not null");
            return (Criteria) this;
        }

        public Criteria andGroupEqualTo(String value) {
            addCriterion("`groupId` =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNotEqualTo(String value) {
            addCriterion("`groupId` <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupGreaterThan(String value) {
            addCriterion("`groupId` >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupGreaterThanOrEqualTo(String value) {
            addCriterion("`groupId` >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupLessThan(String value) {
            addCriterion("`groupId` <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupLessThanOrEqualTo(String value) {
            addCriterion("`groupId` <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupLike(String value) {
            addCriterion("`groupId` like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNotLike(String value) {
            addCriterion("`groupId` not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIn(List<String> values) {
            addCriterion("`groupId` in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNotIn(List<String> values) {
            addCriterion("`groupId` not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupBetween(String value1, String value2) {
            addCriterion("`groupId` between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNotBetween(String value1, String value2) {
            addCriterion("`groupId` not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDatumAddressIsNull() {
            addCriterion("datum_address is null");
            return (Criteria) this;
        }

        public Criteria andDatumAddressIsNotNull() {
            addCriterion("datum_address is not null");
            return (Criteria) this;
        }

        public Criteria andDatumAddressEqualTo(String value) {
            addCriterion("datum_address =", value, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressNotEqualTo(String value) {
            addCriterion("datum_address <>", value, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressGreaterThan(String value) {
            addCriterion("datum_address >", value, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressGreaterThanOrEqualTo(String value) {
            addCriterion("datum_address >=", value, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressLessThan(String value) {
            addCriterion("datum_address <", value, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressLessThanOrEqualTo(String value) {
            addCriterion("datum_address <=", value, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressLike(String value) {
            addCriterion("datum_address like", value, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressNotLike(String value) {
            addCriterion("datum_address not like", value, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressIn(List<String> values) {
            addCriterion("datum_address in", values, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressNotIn(List<String> values) {
            addCriterion("datum_address not in", values, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressBetween(String value1, String value2) {
            addCriterion("datum_address between", value1, value2, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumAddressNotBetween(String value1, String value2) {
            addCriterion("datum_address not between", value1, value2, "datumAddress");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeIsNull() {
            addCriterion("datum_createtime is null");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeIsNotNull() {
            addCriterion("datum_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeEqualTo(Date value) {
            addCriterion("datum_createtime =", value, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeNotEqualTo(Date value) {
            addCriterion("datum_createtime <>", value, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeGreaterThan(Date value) {
            addCriterion("datum_createtime >", value, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("datum_createtime >=", value, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeLessThan(Date value) {
            addCriterion("datum_createtime <", value, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("datum_createtime <=", value, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeIn(List<Date> values) {
            addCriterion("datum_createtime in", values, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeNotIn(List<Date> values) {
            addCriterion("datum_createtime not in", values, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeBetween(Date value1, Date value2) {
            addCriterion("datum_createtime between", value1, value2, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andDatumCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("datum_createtime not between", value1, value2, "datumCreatetime");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}