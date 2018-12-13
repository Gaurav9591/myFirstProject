package project.ses.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	static final String filePath=".\\testdata\\testData.xlsx";

	@SuppressWarnings("deprecation")
	public static String[] toReadExcelData(String sheet,String sTestCaseID)
	{   
		String sData[]=null;
		try
		{

			FileInputStream fis = new FileInputStream(new File(".\\testdata\\testData.xlsx"));
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheet);
			int iRowNum= sht.getLastRowNum();

			for(int i=1;i<=iRowNum;i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new String[iCellNum];

					for(int j=0;j<iCellNum;j++)		
					{
						sData[j]=sht.getRow(i).getCell(j,Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					}
					break;
				}
			}	
		}
		catch(EncryptedDocumentException e)
		{	
			e.printStackTrace();
		}
		catch(InvalidFormatException e)
		{	
			e.printStackTrace();
		}
		catch(IOException e)
		{	
			e.printStackTrace();
		}
		return sData;
	}

	public static void writeData(Sheet s, int rowNum, String S, int Value)
	{
		Row r = s.createRow(rowNum);
		r.createCell(0).setCellValue(S);
		r.createCell(1).setCellValue(Value);	
	}
}
