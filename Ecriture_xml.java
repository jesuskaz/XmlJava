import java.io.File;
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
 
 public class Ecriture_xml
 {
     public static void main(String argv[])
     {
         try
         {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            //Element racine
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("nameOfracine");
            doc.appendChild(rootElement);
            
            //Creation of an attribute
            Attr attr = doc.createAttribute("nameOfAttribute");
            rootElement.setValue(attr);
             //Ecriture de contenue dans le fichier xml
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
             Transformer transformer = transformerFactory.newTransformer();
             DOMSource source = new DOMSource(doc);
             StreamResult resultat = new StreamResult(new File("monFichier.xml"));
             transformer.transform(source,resultat);
             System.out.println("Fichier sauvergarde");
         }
         catch(ParserConfigurationException pce)
         {
             pce.printStackTrace();
         }
         catch(TransformerException tfe)
         {
             tfe.printStackTrace();
         }
     }   
 }
 