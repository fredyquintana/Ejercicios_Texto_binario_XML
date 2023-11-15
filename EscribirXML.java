import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EscribirXML {

    public static void main(String[] args) {
        try {
            // Create a new XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Create root element
            Element rootElement = doc.createElement("Ejemplo");
            doc.appendChild(rootElement);

           // Add elements to the document
            Element elemento1 = doc.createElement("Elemento1");
            elemento1.appendChild(doc.createTextNode("Mi primer Archivo XML"));
            rootElement.appendChild(elemento1);

            Element elemento2 = doc.createElement("Elemento2");
            elemento2.appendChild(doc.createTextNode("Creado por Fredy Quintana Cruz"));
            rootElement.appendChild(elemento2);

            // Save the document to an XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("archivo.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML creado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
