package com.onlines.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseResponseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaseResponseExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andResponseTimeIsNull() {
            addCriterion("response_time is null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNotNull() {
            addCriterion("response_time is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeEqualTo(Long value) {
            addCriterion("response_time =", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotEqualTo(Long value) {
            addCriterion("response_time <>", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThan(Long value) {
            addCriterion("response_time >", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("response_time >=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThan(Long value) {
            addCriterion("response_time <", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThanOrEqualTo(Long value) {
            addCriterion("response_time <=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIn(List<Long> values) {
            addCriterion("response_time in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotIn(List<Long> values) {
            addCriterion("response_time not in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeBetween(Long value1, Long value2) {
            addCriterion("response_time between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotBetween(Long value1, Long value2) {
            addCriterion("response_time not between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNull() {
            addCriterion("case_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("case_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Long value) {
            addCriterion("case_id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Long value) {
            addCriterion("case_id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Long value) {
            addCriterion("case_id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("case_id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Long value) {
            addCriterion("case_id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Long value) {
            addCriterion("case_id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Long> values) {
            addCriterion("case_id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Long> values) {
            addCriterion("case_id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Long value1, Long value2) {
            addCriterion("case_id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Long value1, Long value2) {
            addCriterion("case_id not between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andStatesIsNull() {
            addCriterion("states is null");
            return (Criteria) this;
        }

        public Criteria andStatesIsNotNull() {
            addCriterion("states is not null");
            return (Criteria) this;
        }

        public Criteria andStatesEqualTo(Long value) {
            addCriterion("states =", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotEqualTo(Long value) {
            addCriterion("states <>", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThan(Long value) {
            addCriterion("states >", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThanOrEqualTo(Long value) {
            addCriterion("states >=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThan(Long value) {
            addCriterion("states <", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThanOrEqualTo(Long value) {
            addCriterion("states <=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesIn(List<Long> values) {
            addCriterion("states in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotIn(List<Long> values) {
            addCriterion("states not in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesBetween(Long value1, Long value2) {
            addCriterion("states between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotBetween(Long value1, Long value2) {
            addCriterion("states not between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andFailedReasonIsNull() {
            addCriterion("failed_reason is null");
            return (Criteria) this;
        }

        public Criteria andFailedReasonIsNotNull() {
            addCriterion("failed_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFailedReasonEqualTo(String value) {
            addCriterion("failed_reason =", value, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonNotEqualTo(String value) {
            addCriterion("failed_reason <>", value, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonGreaterThan(String value) {
            addCriterion("failed_reason >", value, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonGreaterThanOrEqualTo(String value) {
            addCriterion("failed_reason >=", value, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonLessThan(String value) {
            addCriterion("failed_reason <", value, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonLessThanOrEqualTo(String value) {
            addCriterion("failed_reason <=", value, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonLike(String value) {
            addCriterion("failed_reason like", value, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonNotLike(String value) {
            addCriterion("failed_reason not like", value, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonIn(List<String> values) {
            addCriterion("failed_reason in", values, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonNotIn(List<String> values) {
            addCriterion("failed_reason not in", values, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonBetween(String value1, String value2) {
            addCriterion("failed_reason between", value1, value2, "failedReason");
            return (Criteria) this;
        }

        public Criteria andFailedReasonNotBetween(String value1, String value2) {
            addCriterion("failed_reason not between", value1, value2, "failedReason");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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