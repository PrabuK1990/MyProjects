


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class List {

	public static void main(String[] args) throws IOException{
		
		File file1 = new File("Zip\\Automation_Test_Run.zip");
		FileOutputStream fos = new FileOutputStream(file1);
		ZipOutputStream zos = new ZipOutputStream(fos);
		
		String fileName = "emailable-report.html";
		
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);

		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);
		
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		
		zos.close();
		fis.close();
		
		file1.delete();
		
		System.out.println("Done");

	}

}
