import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {

	public ArrayList<String> testdata() throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Syed Ghaleb\\Testdata\\demodata.xlsx");
		
XSSFWorkbook wb = new XSSFWorkbook(fis);
int sheets=wb.getNumberOfSheets();
System.out.println(sheets);

for (int i =0 ;i<sheets ;i++)
{
if (wb.getSheetName(i).equalsIgnoreCase("Testdata"))
{
	XSSFSheet  sheet=wb.getSheetAt(i);
	System.out.println(sheet);
	
	Iterator<Row>row =sheet.rowIterator();
	Row firstrow=row.next();
	Iterator<Cell> ce =firstrow.cellIterator();
	int k=0;
	int column =0;
	while(ce.hasNext())
	{
		Cell value =ce.next();
		String v=value.getStringCellValue();
		System.out.println(v);
		if (value.getStringCellValue().equalsIgnoreCase("TestCases1"))
		{
			column=k;
		}
		k++;
		
		
	}
	System.out.println(column);
	
	while(row.hasNext())
	{
		Row r=row.next();
		if (r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase"))
		{
			Iterator <Cell> c=r.cellIterator();
			while(c.hasNext())
			{
			Cell value1=c.next();
			if(value1.getCellType()==CellType.STRING)
			{
//			System.out.println(value1);
		a.add(value1.getStringCellValue());	
		}
			else
			{
			a.add(	NumberToTextConverter.toText(value1.getNumericCellValue()));
			}
	}
		System.out.println (a);
	
}
}
	}



}
return a;
}
}