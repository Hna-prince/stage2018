package com.management.loyality.domain;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class IdGenerator implements IdentifierGenerator, Configurable {

    public static final String  nameParam="predicat";
    private String sequencePrefix;
    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        sequencePrefix = ConfigurationHelper.getString(
                nameParam,
                params,
                "SEQ_");

    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String prefix = this.sequencePrefix;
        Connection connection = sharedSessionContractImplementor.connection();
        try {
            Statement statement=connection.createStatement();
            String request="SELECT nextval('"+prefix+"');";
            ResultSet rs=statement.executeQuery(request);

            if(rs.next())
            {
                int id=rs.getInt(1);
                String generatedId = prefix + new Integer(id).toString();
                return generatedId;
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }


}