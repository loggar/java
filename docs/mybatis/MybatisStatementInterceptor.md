```java
package com.loggar.support.mybatis;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sql log
 *
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }), @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class MybatisStatementInterceptor implements Interceptor {
	private static final Logger logger = LoggerFactory.getLogger(MybatisStatementInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) {
		Object[] args = invocation.getArgs();
		MappedStatement mappedStatement = (MappedStatement) args[0];

		Object objParameter = args[1];
		BoundSql boundSql = mappedStatement.getBoundSql(objParameter);
		StringBuilder sql = new StringBuilder(boundSql.getSql());

		if (objParameter != null) {
			if (objParameter instanceof Map) {
				@SuppressWarnings("unchecked") Map<String, Object> params = (Map<String, Object>) objParameter;

				for (ParameterMapping param : boundSql.getParameterMappings()) {
					String property = param.getProperty();
					int index = sql.indexOf("?");
					sql.replace(index, index + 1, "'" + params.get(property) + "'");
				}
			} else if (objParameter instanceof String) {
				String str_param = (String) objParameter;

				for (ParameterMapping param : boundSql.getParameterMappings()) {
					@SuppressWarnings("unused") String property = param.getProperty();
					int index = sql.indexOf("?");
					sql.replace(index, index + 1, "'" + str_param + "'");
				}
			} else if (objParameter instanceof Integer || objParameter instanceof Double || objParameter instanceof Long || objParameter instanceof Short || objParameter instanceof Float) {
				Integer int_param = (Integer) objParameter;

				for (ParameterMapping param : boundSql.getParameterMappings()) {
					@SuppressWarnings("unused") String property = param.getProperty();
					int index = sql.indexOf("?");
					sql.replace(index, index + 1, int_param.toString());
				}
			} else {
				Class<? extends Object> paramClass = objParameter.getClass();

				for (ParameterMapping parameterMapping : boundSql.getParameterMappings()) {
					String property = parameterMapping.getProperty();
					Field field;
					try {
						field = paramClass.getDeclaredField(property);
						field.setAccessible(true);
						Class<?> javaType = parameterMapping.getJavaType();
						if (javaType == Integer.class || javaType == Double.class || javaType == Long.class || javaType == Short.class || javaType == Float.class) {
							int index = sql.indexOf("?");
							sql.replace(index, index + 1, field.get(objParameter).toString());
						} else {
							int index = sql.indexOf("?");
							sql.replace(index, index + 1, "'" + field.get(objParameter) + "'");
						}
					} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
						logger.error("{}", e);
					}
				}
			}
		}
		logger.debug("{} SQL\n\t\t{}", mappedStatement.getId(), sql.toString());

		try {
			Object proceed = invocation.proceed();
			if (proceed != null && proceed instanceof List) {
				@SuppressWarnings("unchecked") List<Map<String, String>> resultSet = (List<Map<String, String>>) proceed;
				logger.debug("{} Resultset count {}", mappedStatement.getId(), resultSet.size());
			}

			return proceed;
		} catch (Exception e) {
			logger.error("error occur={}", e);
			return null;
		}
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		logger.debug("properties={}", properties);
	}
}

```