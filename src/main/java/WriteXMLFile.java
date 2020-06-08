
import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {

	public static void main(String argv[]) {

	}

	public void writeXML(List<List<String>> pData) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("WORD_FORMS_COLLECTION");
			doc.appendChild(rootElement);

			// staff elements
		//	Element staff = doc.createElement("WORD_FORMS");
		//	rootElement.appendChild(staff);

			// shorten way
			// staff.setAttribute("id", "1");

			for(List<String> subList : pData) {
				System.out.println(subList.size());
				System.out.println(subList);
				Element WORD_FORMS = doc.createElement("WORD_FORMS");
				for(Object element : subList) {
					Element WORD_FORM = doc.createElement("WORD_FORM");
					System.out.println(String.valueOf(element));
					WORD_FORM.appendChild(doc.createTextNode(String.valueOf(element)));
					WORD_FORMS.appendChild(WORD_FORM);
				}
				rootElement.appendChild(WORD_FORMS);
			}
			
			// firstname elements
		//	Element firstname = doc.createElement("firstname");
			//firstname.appendChild(doc.createTextNode("yong"));
			//staff.appendChild(firstname);

			
			System.out.println(doc.toString());

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\file.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}

	

}