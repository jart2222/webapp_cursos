package org.jose.apiservlet.webapp.cursos.headers.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;
import org.jose.apiservlet.webapp.cursos.headers.interceptors.Logging;
import org.jose.apiservlet.webapp.cursos.headers.interceptors.TransactionalJdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TransactionalJdbc
@Logging
@ApplicationScoped
@Stereotype
@Named
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
