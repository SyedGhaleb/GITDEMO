import java.io.IOException;
import java.util.ArrayList;

public class TestExceldata {
	
	public static void main (String[] args) throws IOException
	{
		
		Datadriven data= new Datadriven();
		
		ArrayList<String>  d=data.testdata();
		
	System.out.println(	d.get(0));
	System.out.println(	d.get(1));
	System.out.println(	d.get(2));
	System.out.println(	d.get(3));
	
	//driver.findelement(by.xpath"").sendkey(d.get(0));
	}

}

