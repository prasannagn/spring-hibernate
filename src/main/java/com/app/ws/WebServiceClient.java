package com.app.ws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.WebServiceTemplate;

public class WebServiceClient {

	// private static final String MESSAGE =
	// "<message xmlns=\"http://tempuri.org\">Hello Web Service World</message>";
	// "<HolidayRequest xmlns=\"http://app.com/domain/schemas\">    <Holiday>        <StartDate>2006-07-03</StartDate>        <EndDate>2006-07-07</EndDate>    </Holiday>    <Employee>        <Number>42</Number>        <FirstName>Arjen</FirstName>        <LastName>Poutsma</LastName>    </Employee></HolidayRequest>";

	private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

	public void setDefaultUri(String defaultUri) {
		webServiceTemplate.setDefaultUri(defaultUri);
	}

	// send to the configured default URI
	public void simpleSendAndReceive() {
		StreamSource source = null;
		try {
			source = new StreamSource(new FileReader(new File(
					"C:/Users/Prasanna/Documents/1.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StreamResult result = new StreamResult(System.out);
		webServiceTemplate.sendSourceAndReceiveToResult(source, result);
	}

	// send to an explicit URI
	public void customSendAndReceive() {
		StreamSource source = null;
		try {
			source = new StreamSource(new FileReader(new File(
					"C:/Users/Prasanna/Documents/1.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StreamResult result = new StreamResult(System.out);
		webServiceTemplate.sendSourceAndReceiveToResult(
				"http://localhost:8090/holidayService/holidayService/", source,
				result);
	}

}