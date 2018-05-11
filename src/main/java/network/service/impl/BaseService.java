package network.service.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class BaseService implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(BaseService.class);

    @Resource
    private String defaultDataSource;
    @Resource
    private String mssqlDataSource;

    @Resource
    private Map<String, SqlSession> sqlSessionMap;

    public <T> T getSqlMapper(Class<T> daoClass) {
        return getSqlMapper(daoClass, this.defaultDataSource);
    }

    public <T> T getSqlMapperMsSql(Class<T> daoClass) {
        return getSqlMapper(daoClass, this.mssqlDataSource);
    }

    public <T> T getSqlMapper(Class<T> daoClass, String dsContext) {
        return sqlSessionMap.get(dsContext).getMapper(daoClass);
    }

    public <T> T getSqlMapper(Class<T> daoClass, SqlSession sqlSession) {
        return sqlSession.getMapper(daoClass);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("defaultDataSource=[{}]", this.defaultDataSource);
        log.debug("sqlSessionMap=[{}]", this.sqlSessionMap);
        log.debug("mssqlDataSource=[{}]", this.mssqlDataSource);
        Assert.hasLength(this.defaultDataSource);
        Assert.notNull(this.sqlSessionMap);
    }
}