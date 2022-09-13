package com.ECStraining.ExceldatatoJSON.utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestExcelDataToJSON {

	static File excel = new File("/com.ECSTraining/src/test/resources/StudentDetails.xlsx");
    static JsonNodetoEmail emailobject=new JsonNodetoEmail();
	static ReadingExcelData readingobj=new ReadingExcelData();

	@Test
	public static  void testSendFileToEmail()
	{
		emailobject.SendFileToEmail();
	}
	
	
	@Test
	@Parameters
	public static List<Object[]>  testExcelToJson() throws IOException
	{
     List<Object[]>args = new ArrayList<Object[]>();
	 readingobj.excelToJson(excel);
	 return args;
	}
	
}
