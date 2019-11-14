package com.muffato.relatoriomari.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public void enviar(String mensagem, String assunto, Session mailSession, Message msg, String[] email) {
		mailSession.setDebug(false);
		try {
			msg.setSubject(assunto);
			InternetAddress from = new InternetAddress("coordena.software@muffato.com.br", "Desenvolvimento");
			msg.setFrom(from);
			InternetAddress[] address = null;

			address = new InternetAddress[email.length];
			for (int i = 0; i < email.length; i++) {
				address[i] = new InternetAddress(email[i]);
			}

			msg.setRecipients(Message.RecipientType.TO, address);
			Transport.send(msg);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void enviarArquivo(String assunto, String mensagem, File fileTmp, String... email) throws Exception {
		Properties props = getProperties();
		Authenticator auth = getAuthenticator();
		Session mailSession = Session.getDefaultInstance(props, auth);
		Message message = new MimeMessage(mailSession);

		Calendar dataAtual = Calendar.getInstance();
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual.getTime());

		String titulo = dataFormatada + " - " + assunto;

		try {

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(mensagem);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(fileTmp);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileTmp.getName());
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);
			enviar(mensagem, titulo, mailSession, message, email);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Authenticator getAuthenticator() {
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("desenvolvimento@muffato.com.br", "mUfF@70");
			}
		};
		return auth;
	}

	private Properties getProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.muffato.com.br");
		props.put("mail.smtp.auth", "true");
		return props;
	}

}