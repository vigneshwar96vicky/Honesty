package orh.omega;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FlipKartII extends FilpKartAutoMation {
	int count = 0;
	LinkedList<Object> listu = new LinkedList<Object>();
	LinkedList<Object> listv = new LinkedList<Object>();
	public void closingFront() throws InterruptedException{
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement g = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		Actions i= new Actions(driver);
		i.moveToElement(g);
		i.click();
		i.build().perform();
		i.click(g).sendKeys("redmi mobiles");
		i.build().perform();
		Thread.sleep(2000);
		WebElement o = driver.findElement(By.xpath("//button[@type='submit']"));
		i.click(o);
		i.build().perform();
		Thread.sleep(3000);
	}
	public void wordPrint(){
		for (int i = 3; i < 27; i++) {
			WebElement k = driver.findElement(By.xpath("(//div[contains(text(),'Redmi') or contains(text(),'REDMI') ])["+i+"]"));
			String text = k.getText();
			listu.add(text);
			count++;
		}
		
	}
	public void excelWrite(int po) throws IOException{
		File j = new File("E://Eclipse Workspace/Honesty/Omega/target/Realme.xlsx");
		FileOutputStream u = new FileOutputStream(j);
		Workbook wb = new XSSFWorkbook();
		Sheet sh = wb.createSheet("Realme_Brand");
		for (int i = 0; i < count; i++) {
			Row t = sh.createRow(i);
			Cell y = t.createCell(po);
			String v = (String) listu.get(i);
			y.setCellValue(v);
			
		}
		wb.write(u);
		System.out.println("Done");
	}
	public void windowsHandle(){
		Actions kd = new Actions(driver);
		for (int i = 3; i < 27; i++) {
			String parentName = driver.getWindowHandle();
			WebElement hg = driver.findElement(By.xpath("(//div[contains(text(),'Redmi') or contains(text(),'REDMI') ])["+i+"]"));
			kd.click(hg);
			kd.build().perform();
			Set<String> df = driver.getWindowHandles();
			for (String st : df) {
				if(!parentName.equals(st)){
					driver.switchTo().window(st);
				}
			}
			WebElement tr = driver.findElement(By.xpath("//span[contains(text(),'Redmi') or contains(text(),'REDMI') ]"));
			String text = tr.getText();
			listv.add(text);
			driver.close();
			driver.switchTo().window(parentName);	
		}
		System.out.println("very good");
		System.out.println("windows handle success full");
		
	}
	public void excelLoad() throws IOException{
		File j = new File("E:\\Eclipse Workspace\\Honesty\\Omega\\target\\Redmi-1.xlsx");
		FileOutputStream u = new FileOutputStream(j);
		Workbook wb = new XSSFWorkbook();
		Sheet sh = wb.createSheet("Realme_Brand");
		for (int i = 0; i < count; i++) {
			Row t = sh.createRow(i);
			Cell y = t.createCell(0);
			String v = (String) listv.get(i);
			y.setCellValue(v);
			
		}
		wb.write(u);
	}
	public void excelRead() throws IOException{
		
		FileInputStream u = new FileInputStream("E://Eclipse Workspace/Honesty/Omega/target/Realme.xlsx");
		Workbook wb = new XSSFWorkbook(u);
		XSSFSheet sht = (XSSFSheet) wb.getSheetAt(0);
		System.out.println("read Excel");
		System.out.println("Trail 1"); 
		int rowNum = sht.getLastRowNum();
		int colNum = sht.getRow(0).getLastCellNum();
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				XSSFCell gf = (XSSFCell) sht.getRow(i).getCell(j);
				String txt = gf.getStringCellValue();
				System.out.println(txt);
			}
		}
		System.out.println("finish");
		
	}
	
	public static void main(String[] args) throws InterruptedException, IOException{
		FlipKartII h = new FlipKartII();
		h.URL("https://www.flipkart.com");
		h.closingFront();
		h.wordPrint();
		h.excelWrite(0);
		h.windowsHandle();
		h.excelLoad();
		h.excelRead();
	}
}
