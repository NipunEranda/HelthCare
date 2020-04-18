package com.healthCare.Servlet;

import com.google.gson.JsonObject;
import com.healthCare.model.*;

public class AccessFilter {

	public static boolean checkAccess(String[] giveAccess, String authString) {

		boolean status = false;

		if (authString != null) {
			JsonObject obj = Response.getResponse(
					"http://localhost:8080/HealthCareLoginManagement/webapi/login/authorizeUser/", authString);
			for (String access : giveAccess) {

				String role = obj.get("role").getAsString();

				if (role.equalsIgnoreCase(access)) {
					status = true;
				}

			}
		}
		return status;
	}

}
