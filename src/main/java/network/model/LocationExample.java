package network.model;

import java.util.ArrayList;
import java.util.List;

public class LocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LocationExample() {
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

        public Criteria andLIdIsNull() {
            addCriterion("l_id is null");
            return (Criteria) this;
        }

        public Criteria andLIdIsNotNull() {
            addCriterion("l_id is not null");
            return (Criteria) this;
        }

        public Criteria andLIdEqualTo(Long value) {
            addCriterion("l_id =", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotEqualTo(Long value) {
            addCriterion("l_id <>", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdGreaterThan(Long value) {
            addCriterion("l_id >", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdGreaterThanOrEqualTo(Long value) {
            addCriterion("l_id >=", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdLessThan(Long value) {
            addCriterion("l_id <", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdLessThanOrEqualTo(Long value) {
            addCriterion("l_id <=", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdIn(List<Long> values) {
            addCriterion("l_id in", values, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotIn(List<Long> values) {
            addCriterion("l_id not in", values, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdBetween(Long value1, Long value2) {
            addCriterion("l_id between", value1, value2, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotBetween(Long value1, Long value2) {
            addCriterion("l_id not between", value1, value2, "lId");
            return (Criteria) this;
        }

        public Criteria andLocationNameIsNull() {
            addCriterion("location_name is null");
            return (Criteria) this;
        }

        public Criteria andLocationNameIsNotNull() {
            addCriterion("location_name is not null");
            return (Criteria) this;
        }

        public Criteria andLocationNameEqualTo(String value) {
            addCriterion("location_name =", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotEqualTo(String value) {
            addCriterion("location_name <>", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameGreaterThan(String value) {
            addCriterion("location_name >", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameGreaterThanOrEqualTo(String value) {
            addCriterion("location_name >=", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLessThan(String value) {
            addCriterion("location_name <", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLessThanOrEqualTo(String value) {
            addCriterion("location_name <=", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLike(String value) {
            addCriterion("location_name like", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotLike(String value) {
            addCriterion("location_name not like", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameIn(List<String> values) {
            addCriterion("location_name in", values, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotIn(List<String> values) {
            addCriterion("location_name not in", values, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameBetween(String value1, String value2) {
            addCriterion("location_name between", value1, value2, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotBetween(String value1, String value2) {
            addCriterion("location_name not between", value1, value2, "locationName");
            return (Criteria) this;
        }

        public Criteria andMinLcationXIsNull() {
            addCriterion("min_lcation_x is null");
            return (Criteria) this;
        }

        public Criteria andMinLcationXIsNotNull() {
            addCriterion("min_lcation_x is not null");
            return (Criteria) this;
        }

        public Criteria andMinLcationXEqualTo(Double value) {
            addCriterion("min_lcation_x =", value, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXNotEqualTo(Double value) {
            addCriterion("min_lcation_x <>", value, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXGreaterThan(Double value) {
            addCriterion("min_lcation_x >", value, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXGreaterThanOrEqualTo(Double value) {
            addCriterion("min_lcation_x >=", value, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXLessThan(Double value) {
            addCriterion("min_lcation_x <", value, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXLessThanOrEqualTo(Double value) {
            addCriterion("min_lcation_x <=", value, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXIn(List<Double> values) {
            addCriterion("min_lcation_x in", values, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXNotIn(List<Double> values) {
            addCriterion("min_lcation_x not in", values, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXBetween(Double value1, Double value2) {
            addCriterion("min_lcation_x between", value1, value2, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationXNotBetween(Double value1, Double value2) {
            addCriterion("min_lcation_x not between", value1, value2, "minLcationX");
            return (Criteria) this;
        }

        public Criteria andMinLcationYIsNull() {
            addCriterion("min_lcation_y is null");
            return (Criteria) this;
        }

        public Criteria andMinLcationYIsNotNull() {
            addCriterion("min_lcation_y is not null");
            return (Criteria) this;
        }

        public Criteria andMinLcationYEqualTo(Double value) {
            addCriterion("min_lcation_y =", value, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYNotEqualTo(Double value) {
            addCriterion("min_lcation_y <>", value, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYGreaterThan(Double value) {
            addCriterion("min_lcation_y >", value, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYGreaterThanOrEqualTo(Double value) {
            addCriterion("min_lcation_y >=", value, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYLessThan(Double value) {
            addCriterion("min_lcation_y <", value, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYLessThanOrEqualTo(Double value) {
            addCriterion("min_lcation_y <=", value, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYIn(List<Double> values) {
            addCriterion("min_lcation_y in", values, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYNotIn(List<Double> values) {
            addCriterion("min_lcation_y not in", values, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYBetween(Double value1, Double value2) {
            addCriterion("min_lcation_y between", value1, value2, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMinLcationYNotBetween(Double value1, Double value2) {
            addCriterion("min_lcation_y not between", value1, value2, "minLcationY");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXIsNull() {
            addCriterion("max_lcation_x is null");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXIsNotNull() {
            addCriterion("max_lcation_x is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXEqualTo(Double value) {
            addCriterion("max_lcation_x =", value, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXNotEqualTo(Double value) {
            addCriterion("max_lcation_x <>", value, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXGreaterThan(Double value) {
            addCriterion("max_lcation_x >", value, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXGreaterThanOrEqualTo(Double value) {
            addCriterion("max_lcation_x >=", value, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXLessThan(Double value) {
            addCriterion("max_lcation_x <", value, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXLessThanOrEqualTo(Double value) {
            addCriterion("max_lcation_x <=", value, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXIn(List<Double> values) {
            addCriterion("max_lcation_x in", values, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXNotIn(List<Double> values) {
            addCriterion("max_lcation_x not in", values, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXBetween(Double value1, Double value2) {
            addCriterion("max_lcation_x between", value1, value2, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLcationXNotBetween(Double value1, Double value2) {
            addCriterion("max_lcation_x not between", value1, value2, "maxLcationX");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYIsNull() {
            addCriterion("max_location_y is null");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYIsNotNull() {
            addCriterion("max_location_y is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYEqualTo(Double value) {
            addCriterion("max_location_y =", value, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYNotEqualTo(Double value) {
            addCriterion("max_location_y <>", value, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYGreaterThan(Double value) {
            addCriterion("max_location_y >", value, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYGreaterThanOrEqualTo(Double value) {
            addCriterion("max_location_y >=", value, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYLessThan(Double value) {
            addCriterion("max_location_y <", value, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYLessThanOrEqualTo(Double value) {
            addCriterion("max_location_y <=", value, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYIn(List<Double> values) {
            addCriterion("max_location_y in", values, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYNotIn(List<Double> values) {
            addCriterion("max_location_y not in", values, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYBetween(Double value1, Double value2) {
            addCriterion("max_location_y between", value1, value2, "maxLocationY");
            return (Criteria) this;
        }

        public Criteria andMaxLocationYNotBetween(Double value1, Double value2) {
            addCriterion("max_location_y not between", value1, value2, "maxLocationY");
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