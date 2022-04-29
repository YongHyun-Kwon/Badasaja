package kr.co.sist.badasaja.user.dao;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTPDAO {

	/**
	 * ���Ϻ����� DAO
	 * 
	 * @return
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void smtpPass(String email ,String password) throws MessagingException, UnsupportedEncodingException {

		Properties prop = System.getProperties();
		// ��������
		// �α��ν� TLS�� ����� ������ ����
		prop.put("mail.smtp.starttls.enable", "true");

		// �̸��� �߼��� ó������ SMTP����
		prop.put("mail.smtp.host", "smtp.gmail.com");

		// SMTP ������ ������ ����Ѵٴ� �ǹ�
		prop.put("mail.smtp.auth", "true");

		// TLS�� ��Ʈ��ȣ�� 587�̸� SSL�� ��Ʈ��ȣ�� 465�̴�.
		prop.put("mail.smtp.port", "587");
		// jdk������ TLS������ ����ϴ�.
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Authenticator auth = new SMTPAuthenticatior();

		Session session = Session.getDefaultInstance(prop, auth);

		MimeMessage msg = new MimeMessage(session);

		/* try { */
		// ������ ��¥ ����
		msg.setSentDate(new Date());

		// �߼��ڸ� �����Ѵ�. �߼����� ����, �߼��ڸ�
		msg.setFrom(new InternetAddress("panosun96@gmail.com", "�ٴٻ���"));

		// �������� ������ �����Ѵ�.
		InternetAddress to = new InternetAddress(email);

		// Message Ŭ������ setRecipient() �޼ҵ带 ����Ͽ� �����ڸ� �����Ѵ�. setRecipient() �޼ҵ�� ������, ����,
		// ���� ���� ������ �����ϴ�.
		// Message.RecipientType.TO : �޴� ���
		// Message.RecipientType.CC : ����
		// Message.RecipientType.BCC : ���� ����
		msg.setRecipient(Message.RecipientType.TO, to);

		// ������ ���� ����
		msg.setSubject("�ٴٻ��� ��й�ȣ�� ����Ǿ����ϴ�. ", "UTF-8");

		// Transport�� ������ ���������� ������ Ŭ������ ������ ������ �κ��̴�.
		StringBuilder str = new StringBuilder();
		str.append("�ӽú�й�ȣ��").append(password).append("�Դϴ�.");
		msg.setText(str.toString(), "UTF-8");

		Transport.send(msg);
		

	}

	public boolean smtId(String email ,String id) throws MessagingException, UnsupportedEncodingException {

		Properties prop = System.getProperties();
		// ��������
		// �α��ν� TLS�� ����� ������ ����
		prop.put("mail.smtp.starttls.enable", "true");

		// �̸��� �߼��� ó������ SMTP����
		prop.put("mail.smtp.host", "smtp.gmail.com");

		// SMTP ������ ������ ����Ѵٴ� �ǹ�
		prop.put("mail.smtp.auth", "true");

		// TLS�� ��Ʈ��ȣ�� 587�̸� SSL�� ��Ʈ��ȣ�� 465�̴�.
		prop.put("mail.smtp.port", "587");
		// jdk������ TLS������ ����ϴ�.
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Authenticator auth = new SMTPAuthenticatior();

		Session session = Session.getDefaultInstance(prop, auth);

		MimeMessage msg = new MimeMessage(session);

		/* try { */
		// ������ ��¥ ����
		msg.setSentDate(new Date());

		// �߼��ڸ� �����Ѵ�. �߼����� ����, �߼��ڸ�
		msg.setFrom(new InternetAddress("panosun96@gmail.com", "�ٴٻ���"));

		// �������� ������ �����Ѵ�.
		InternetAddress to = new InternetAddress(email);

		// Message Ŭ������ setRecipient() �޼ҵ带 ����Ͽ� �����ڸ� �����Ѵ�. setRecipient() �޼ҵ�� ������, ����,
		// ���� ���� ������ �����ϴ�.
		// Message.RecipientType.TO : �޴� ���
		// Message.RecipientType.CC : ����
		// Message.RecipientType.BCC : ���� ����
		msg.setRecipient(Message.RecipientType.TO, to);

		// ������ ���� ����
		msg.setSubject("�ٴٻ��� ���̵� ã�� ��� ", "UTF-8");

		// Transport�� ������ ���������� ������ Ŭ������ ������ ������ �κ��̴�.
		StringBuilder str = new StringBuilder();
		str.append("���̵��").append(id).append("�Դϴ�.");
		msg.setText(str.toString(), "UTF-8");

		Transport.send(msg);

		return true;
	}

	public String tempPass() {
		int leftLimit = 97; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 6;
		Random random = new Random();
		// ����ҹ���
		String pass1 = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)// ���۰� ���� ����
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		// ����
		leftLimit = 48;
		rightLimit = 57;
		targetStringLength = 1;
		String pass2 = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)// ���۰� ���� ����
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		// Ư������
		leftLimit = 33;
		rightLimit = 47;
		targetStringLength = 1;
		String pass3 = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		StringBuilder password = new StringBuilder();
		password.append(pass1).append(pass2).append(pass3);

		return password.toString();
	}

}
