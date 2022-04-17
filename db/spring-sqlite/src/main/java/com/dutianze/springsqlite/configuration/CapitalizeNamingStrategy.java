package com.dutianze.springsqlite.configuration;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * @author dutianze
 * @date 2022/4/18
 */
public class CapitalizeNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return getIdentifier(name.getText(), name.isQuoted(), jdbcEnvironment );
    }

    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        String capitalize = StringUtils.capitalize(name);
        return new Identifier(StringUtils.capitalize(name), quoted);
    }
}
