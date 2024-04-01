/*
package com.loginAssessment.loginAssessment.springapachewicket;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import com.loginAssessment.loginAssessment.dto.UserDto;
import com.loginAssessment.loginAssessment.request.LoginRequest;
import com.loginAssessment.loginAssessment.service.LoginService;
import com.loginAssessment.loginAssessment.service.UserService;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.http.ResponseEntity;

@WicketSignInPage
public class LoginPage extends WebPage {


	@SpringBean
	private LoginService loginService;

	public LoginPage(PageParameters parameters) {
		super(parameters);

		if (((AbstractAuthenticatedWebSession) getSession()).isSignedIn()) {
			continueToOriginalDestination();
		}
		add(new LoginForm("loginForm"));
	}

	private class LoginForm extends Form<LoginForm> {

		private Long userId;

		private String password;

		public LoginForm(String id) {
			super(id);
			setModel(new CompoundPropertyModel<>(this));
			add(new FeedbackPanel("feedback"));
			add(new RequiredTextField<String>("username"));
			add(new PasswordTextField("password"));
		}

		@Override
		protected void onSubmit() {
			UserDto userDto = new UserDto();
			userDto.setUserId(userId);
			userDto.setPassword(password);
			ResponseEntity<?> responseEntity = loginService.userLogin(new LoginRequest(userId, password));
			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				AuthenticatedWebSession session = AuthenticatedWebSession.get();
				session.signIn(userId.toString(), password);
				setResponsePage(HomePage.class);
			} else {
				error("Login failed");
			}
		}
	}
}
*/
