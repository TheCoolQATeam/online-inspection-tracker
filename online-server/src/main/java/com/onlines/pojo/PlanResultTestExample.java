package com.onlines.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanResultTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanResultTestExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNull() {
            addCriterion("total_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNotNull() {
            addCriterion("total_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumEqualTo(Integer value) {
            addCriterion("total_num =", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotEqualTo(Integer value) {
            addCriterion("total_num <>", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThan(Integer value) {
            addCriterion("total_num >", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_num >=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThan(Integer value) {
            addCriterion("total_num <", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_num <=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIn(List<Integer> values) {
            addCriterion("total_num in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotIn(List<Integer> values) {
            addCriterion("total_num not in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("total_num between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_num not between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumIsNull() {
            addCriterion("passed_num is null");
            return (Criteria) this;
        }

        public Criteria andPassedNumIsNotNull() {
            addCriterion("passed_num is not null");
            return (Criteria) this;
        }

        public Criteria andPassedNumEqualTo(Integer value) {
            addCriterion("passed_num =", value, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumNotEqualTo(Integer value) {
            addCriterion("passed_num <>", value, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumGreaterThan(Integer value) {
            addCriterion("passed_num >", value, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("passed_num >=", value, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumLessThan(Integer value) {
            addCriterion("passed_num <", value, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumLessThanOrEqualTo(Integer value) {
            addCriterion("passed_num <=", value, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumIn(List<Integer> values) {
            addCriterion("passed_num in", values, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumNotIn(List<Integer> values) {
            addCriterion("passed_num not in", values, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumBetween(Integer value1, Integer value2) {
            addCriterion("passed_num between", value1, value2, "passedNum");
            return (Criteria) this;
        }

        public Criteria andPassedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("passed_num not between", value1, value2, "passedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumIsNull() {
            addCriterion("failed_num is null");
            return (Criteria) this;
        }

        public Criteria andFailedNumIsNotNull() {
            addCriterion("failed_num is not null");
            return (Criteria) this;
        }

        public Criteria andFailedNumEqualTo(Integer value) {
            addCriterion("failed_num =", value, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumNotEqualTo(Integer value) {
            addCriterion("failed_num <>", value, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumGreaterThan(Integer value) {
            addCriterion("failed_num >", value, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("failed_num >=", value, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumLessThan(Integer value) {
            addCriterion("failed_num <", value, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumLessThanOrEqualTo(Integer value) {
            addCriterion("failed_num <=", value, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumIn(List<Integer> values) {
            addCriterion("failed_num in", values, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumNotIn(List<Integer> values) {
            addCriterion("failed_num not in", values, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumBetween(Integer value1, Integer value2) {
            addCriterion("failed_num between", value1, value2, "failedNum");
            return (Criteria) this;
        }

        public Criteria andFailedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("failed_num not between", value1, value2, "failedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumIsNull() {
            addCriterion("skiped_num is null");
            return (Criteria) this;
        }

        public Criteria andSkipedNumIsNotNull() {
            addCriterion("skiped_num is not null");
            return (Criteria) this;
        }

        public Criteria andSkipedNumEqualTo(Integer value) {
            addCriterion("skiped_num =", value, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumNotEqualTo(Integer value) {
            addCriterion("skiped_num <>", value, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumGreaterThan(Integer value) {
            addCriterion("skiped_num >", value, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("skiped_num >=", value, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumLessThan(Integer value) {
            addCriterion("skiped_num <", value, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumLessThanOrEqualTo(Integer value) {
            addCriterion("skiped_num <=", value, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumIn(List<Integer> values) {
            addCriterion("skiped_num in", values, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumNotIn(List<Integer> values) {
            addCriterion("skiped_num not in", values, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumBetween(Integer value1, Integer value2) {
            addCriterion("skiped_num between", value1, value2, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andSkipedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("skiped_num not between", value1, value2, "skipedNum");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Long value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Long value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Long value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Long value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Long value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Long> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Long> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Long value1, Long value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Long value1, Long value2) {
            addCriterion("duration not between", value1, value2, "duration");
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