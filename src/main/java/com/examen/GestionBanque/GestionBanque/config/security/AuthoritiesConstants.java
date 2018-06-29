package com.examen.GestionBanque.GestionBanque.config.security;

/**
 * Constants for Spring Security authorities roles.
 */
public final class AuthoritiesConstants {

	public static final String ADMIN = "ROLE_ADMIN";

	public static final String USER = "ROLE_USER";

	public static final String EMPLOYEE = "ROLE_EMPLOYEE";

	public static final String ANONYMOUS = "ROLE_ANONYMOUS";

	private AuthoritiesConstants() {
	}
}
