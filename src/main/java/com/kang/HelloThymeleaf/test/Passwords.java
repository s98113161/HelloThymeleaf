package com.kang.HelloThymeleaf.test;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert.List({
@ScriptAssert(lang="javascript",script="_this.password.equals(_this.confPassword)",
        message="Your password must match."),
        })   

public class Passwords {
@Size(min=2,max=5)
private String password;
@Size(min=2,max=5)
@NotNull
private String confPassword;

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfPassword() {
	return confPassword;
}

public void setConfPassword(String confPassword) {
	this.confPassword = confPassword;
}



}
