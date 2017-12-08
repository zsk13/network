package network.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegistrationExample() {
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

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(Long value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(Long value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(Long value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(Long value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(Long value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(Long value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<Long> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<Long> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(Long value1, Long value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(Long value1, Long value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLocationXIsNull() {
            addCriterion("location_x is null");
            return (Criteria) this;
        }

        public Criteria andLocationXIsNotNull() {
            addCriterion("location_x is not null");
            return (Criteria) this;
        }

        public Criteria andLocationXEqualTo(Float value) {
            addCriterion("location_x =", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXNotEqualTo(Float value) {
            addCriterion("location_x <>", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXGreaterThan(Float value) {
            addCriterion("location_x >", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXGreaterThanOrEqualTo(Float value) {
            addCriterion("location_x >=", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXLessThan(Float value) {
            addCriterion("location_x <", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXLessThanOrEqualTo(Float value) {
            addCriterion("location_x <=", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXIn(List<Float> values) {
            addCriterion("location_x in", values, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXNotIn(List<Float> values) {
            addCriterion("location_x not in", values, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXBetween(Float value1, Float value2) {
            addCriterion("location_x between", value1, value2, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXNotBetween(Float value1, Float value2) {
            addCriterion("location_x not between", value1, value2, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationYIsNull() {
            addCriterion("location_y is null");
            return (Criteria) this;
        }

        public Criteria andLocationYIsNotNull() {
            addCriterion("location_y is not null");
            return (Criteria) this;
        }

        public Criteria andLocationYEqualTo(Float value) {
            addCriterion("location_y =", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYNotEqualTo(Float value) {
            addCriterion("location_y <>", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYGreaterThan(Float value) {
            addCriterion("location_y >", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYGreaterThanOrEqualTo(Float value) {
            addCriterion("location_y >=", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYLessThan(Float value) {
            addCriterion("location_y <", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYLessThanOrEqualTo(Float value) {
            addCriterion("location_y <=", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYIn(List<Float> values) {
            addCriterion("location_y in", values, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYNotIn(List<Float> values) {
            addCriterion("location_y not in", values, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYBetween(Float value1, Float value2) {
            addCriterion("location_y between", value1, value2, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYNotBetween(Float value1, Float value2) {
            addCriterion("location_y not between", value1, value2, "locationY");
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
            addCriterion("s_time =", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotEqualTo(Date value) {
            addCriterion("s_time <>", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeGreaterThan(Date value) {
            addCriterion("s_time >", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("s_time >=", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeLessThan(Date value) {
            addCriterion("s_time <", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeLessThanOrEqualTo(Date value) {
            addCriterion("s_time <=", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeIn(List<Date> values) {
            addCriterion("s_time in", values, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotIn(List<Date> values) {
            addCriterion("s_time not in", values, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeBetween(Date value1, Date value2) {
            addCriterion("s_time between", value1, value2, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotBetween(Date value1, Date value2) {
            addCriterion("s_time not between", value1, value2, "sTime");
            return (Criteria) this;
        }

        public Criteria andETimeIsNull() {
            addCriterion("e_time is null");
            return (Criteria) this;
        }

        public Criteria andETimeIsNotNull() {
            addCriterion("e_time is not null");
            return (Criteria) this;
        }

        public Criteria andETimeEqualTo(Date value) {
            addCriterion("e_time =", value, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeNotEqualTo(Date value) {
            addCriterion("e_time <>", value, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeGreaterThan(Date value) {
            addCriterion("e_time >", value, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeGreaterThanOrEqualTo(Date value) {
            addCriterion("e_time >=", value, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeLessThan(Date value) {
            addCriterion("e_time <", value, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeLessThanOrEqualTo(Date value) {
            addCriterion("e_time <=", value, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeIn(List<Date> values) {
            addCriterion("e_time in", values, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeNotIn(List<Date> values) {
            addCriterion("e_time not in", values, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeBetween(Date value1, Date value2) {
            addCriterion("e_time between", value1, value2, "eTime");
            return (Criteria) this;
        }

        public Criteria andETimeNotBetween(Date value1, Date value2) {
            addCriterion("e_time not between", value1, value2, "eTime");
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