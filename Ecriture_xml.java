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
             Element repertoire = doc.createElement("repertoire");
             doc.appendChild(repertoire);
             //Element contact
             Element contact = doc.createElement("contact");
             repertoire.appendChild(contact);
             //Attribut de l'element contact
             Attr attr = doc.createAttribute("id");
             attr.setValue("1");
             contact.setAttributeNode(attr);
             //Le nom
             Element nom = doc.createElement("nom");
             nom.appendChild(doc.createTextNode("King"));
             contact.appendChild(nom);
             //Prenom
             Element prenom = doc.createElement("prenom");
             prenom.appendChild(doc.createTextNode("java"));
             contact.appendChild(prenom);
             //Mobile
             Element mobile = doc.createElement("mobile");
             mobile.appendChild(doc.createTextNode("343434343"));
             contact.appendChild(mobile);
             //Email
             Element email = doc.createElement("email");
             email.appendChild(doc.createTextNode("code@gmail.com"));
             contact.appendChild(email);
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
 