package org.jose.apiservlet.webapp.cursos.headers.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.jose.apiservlet.webapp.cursos.headers.configs.MysqlConn;
import org.jose.apiservlet.webapp.cursos.headers.service.ServiceJdbcException;

import java.sql.Connection;
import java.util.logging.Logger;

@TransactionalJdbc
@Interceptor
public class TransactionalInterceptor {
    @Inject
    @MysqlConn
    private Connection conn;

    @Inject
    private Logger log;

    @AroundInvoke
    private Object trasactional(InvocationContext invocation) throws Exception{
        if (conn.getAutoCommit()==true){
            conn.setAutoCommit(false);
        }
        try {

            log.info("-----> iniciando transaccion "+invocation.getMethod().getName()+
                    " de la clase "+invocation.getMethod().getDeclaringClass());
            Object resultado=invocation.proceed();
            conn.commit();
            log.info("-----> realizando commit y finalizando transaccion "+ invocation.getMethod().getName() +
                    " de la clase "+invocation.getMethod().getDeclaringClass());
            return  resultado;
        }catch (ServiceJdbcException e){
            conn.rollback();
            throw e;
        }
    }
}
