package network.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CourseStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseStudentExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCsIdIsNull() {
            addCriterion("cs_id is null");
            return (Criteria) this;
        }

        public Criteria andCsIdIsNotNull() {
            addCriterion("cs_id is not null");
            return (Criteria) this;
        }

        public Criteria andCsIdEqualTo(Long value) {
            addCriterion("cs_id =", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotEqualTo(Long value) {
            addCriterion("cs_id <>", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThan(Long value) {
            addCriterion("cs_id >", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cs_id >=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThan(Long value) {
            addCriterion("cs_id <", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThanOrEqualTo(Long value) {
            addCriterion("cs_id <=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdIn(List<Long> values) {
            addCriterion("cs_id in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotIn(List<Long> values) {
            addCriterion("cs_id not in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdBetween(Long value1, Long value2) {
            addCriterion("cs_id between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotBetween(Long value1, Long value2) {
            addCriterion("cs_id not between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Long value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Long value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Long value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Long value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Long value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Long value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Long> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Long> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Long value1, Long value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Long value1, Long value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Long value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Long value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Long value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Long value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Long value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Long value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Long> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Long> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Long value1, Long value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Long value1, Long value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSTimeIsNull() {
            addCriterion("s_time is null");
            return (Criteria) this;
        }

        public Criteria andSTimeIsNotNull() {
            addCriterion("s_time is not null");
            return (Criteria) this;
        }

        public Criteria andSTimeEqualTo(Date value) {
            addCriterionForJDBCDate("s_time =", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("s_time <>", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("s_time >", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_time >=", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeLessThan(Date value) {
            addCriterionForJDBCDate("s_time <", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_time <=", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeIn(List<Date> values) {
            addCriterionForJDBCDate("s_time in", values, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("s_time not in", values, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_time between", value1, value2, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_time not between", value1, value2, "sTime");
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