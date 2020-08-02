import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

class Email {
	
	public static String zipFile;
	public static String fileName;
	public static String user;
	public static String password;
	public static String to;
	public static String host;
	public static String line1;
	public static String line2;
	public static String line3;
	public static String note1;
	public static String thanks;
	public static String name;
	public static String bodyEmail;
	public static int length;
	static File file1;
	static FileOutputStream fos;
	static ZipOutputStream zos;
	static File file;
	static FileInputStream fis;
	static ZipEntry zipEntry;
	static Properties props;
	static BodyPart messageBodyPart1;
	static MimeBodyPart messageBodyPart2;
	static MimeMessage message;
	static DataSource source;
	static Multipart multipart;
	static Session session;
	

	public void sendEmail() throws IOException {

		//Save Test Log and Zip it
		saveTestNGLog();
		
		//Send Email To 
		sendEmailTo();
	}
	
	public void saveTestNGLog() throws IOException
	{
		zipFile = "Zip\\Automation_Test_Run.zip";

		file1 = new File(zipFile);
		fos = new FileOutputStream(file1);
		ZipOutputStream zos = new ZipOutputStream(fos);

		fileName = "test-output\\emailable-report.html";

		file = new File(fileName);
		fis = new FileInputStream(file);

		zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.close();
		fis.close();
	}
	
	public void sendEmailTo()
	{
		to = "prabu.kumar.qa@gmail.com";
		user = "automated.email.qa@gmail.com";
		password = "Newthings@123";
		host = "smtp.gmail.com";

		props = new Properties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Automation Test Run Summary");

			messageBodyPart1 = new MimeBodyPart();

			line1 = "Hi,";
			line2 = "Automation Test Execution completed Successfully.";
			line3 = "Please find the log results zip file attached. Kindly download and extract it to view the test run summary.";
			note1 = "Note : This is an auto-generated email, Please do not reply.";
			thanks = "Thanks.";
			name = "Team QA";
			bodyEmail = line1 + "\n" + "\n" + line2 + "\n" + "\n" + line3 + "\n" + "\n" + note1 + "\n" + "\n"
					+ thanks + "\n" + name;

			messageBodyPart1.setText(bodyEmail);

			messageBodyPart2 = new MimeBodyPart();

			source = new FileDataSource(zipFile);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(zipFile);

			multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);

			message.setContent(multipart);

			Transport.send(message);

			file1.delete();

			System.out.println("message sent....");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}