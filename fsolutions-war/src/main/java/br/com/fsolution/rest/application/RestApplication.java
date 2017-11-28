package br.com.fsolution.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.fsolution.rest.impl.FSolutionServiceImpl;

@ApplicationPath("/")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(FSolutionServiceImpl.class);
		return classes;
	}

}
