<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>



<body>
	<div id="container">


		<form:form commandName="newMember" id="reg">

			<table>
				<tbody>
					<tr>
						<td><form:label path="id">Id:</form:label></td>
						<td><form:input path="id" /></td>
						<td><form:errors class="invalid" path="id" /></td>
					</tr>

					<tr>
						<td><form:label path="name">Name:</form:label></td>
						<td><form:input path="name" /></td>
						<td><form:errors class="invalid" path="name" /></td>
					</tr>
					<tr>
						<td><form:label path="email">Email:</form:label></td>
						<td><form:input path="email" /></td>
						<td><form:errors class="invalid" path="email" /></td>
					</tr>
					<tr>
						<td><form:label path="phoneNumber">Phone #:</form:label>
						<td><form:input path="phoneNumber" /></td>
						<td><form:errors class="invalid" path="phoneNumber" /></td>
					</tr>

				</tbody>
			</table>
			<table>
				<tr>
					<td><input type="submit" value="Register" class="register" />
					</td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>
