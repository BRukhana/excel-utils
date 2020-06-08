
public class Main {

	public static void main(String[] args) {
		ExcelReader er = new ExcelReader();
		System.out.println(er.getData().size());
		WriteXMLFile wx = new WriteXMLFile();
		wx.writeXML(er.getData());
		
	}
	
	
	
}
