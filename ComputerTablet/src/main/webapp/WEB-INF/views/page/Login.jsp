<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="center_content">
	<div class="center_title_bar">Login</div>
	<div class="centerpage">
		<div class="specifications2">
			<form action="login.do" method="post">
				<table style="text-align: right">
					<tr>
						<td style="width: 120px">Username:</td>
						<td style="width: 10px"></td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td style="width: 10px"></td>
						<td><input type="password" name="password" /></td>
					</tr>
				</table>
				<input type="submit" name="btnOK" value="OK" /> 
				<input type="submit" name="btnCancel" value="Cancel" />

			</form>
		</div>
	</div>

	<div class="center_title_bar">Register</div>
	<div class="centerpage">
		<div class="specifications2">
			<form action="">
				<table style="text-align: right">
					<tr>
						<td style="width: 120px">Username:</td>
						<td style="width: 10px"></td>
						<td><input type="text" name="usernameRe" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td style="width: 10px"></td>
						<td><input type="password" name="passwordRe" /></td>
					</tr>
					<tr>
						<td>Full Name:</td>
						<td style="width: 10px"></td>
						<td><input type="password" name="fullname" /></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td style="width: 10px"></td>
						<td><input type="password" name="address" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td style="width: 10px"></td>
						<td><input type="password" name="email" /></td>
					</tr>
					
				</table>
				<input type="submit" name="btnOK" value="OK" /> 
				<input type="submit" name="btnCancel" value="Cancel" />
			</form>
		</div>
	</div>
</div>