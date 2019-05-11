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
            Element rootElement = doc.createElement("table");
            doc.appendChild(rootElement);
             //The container
            Element identite = doc.createElement("Identite");
            rootElement.appendChild(identite);
            //name
            Element nom = doc.createElement("nom");
            rootElement.appendChild(nom);
            //postNom
            Element postnom = doc.createElement("postnom");
            rootElement.appendChild(postnom);
            //prenom
            Element prenom = doc.createElement("prenom");
            rootElement.appendChild(prenom);
            //adresse
            Element adresse = doc.createElement("adresse");
            rootElement.appendChild(adresse);
            //date de naissance
            Element date = doc.createElement("dateNaissance");
            rootElement.appendChild(date);
            //promotion
            Element promotion = doc.createElement("promotion");
            rootElement.appendChild(promotion);
            //etc.....
            //Creation of an attribute of name
            Attr attr = doc.createAttribute("id");
            attr.setValue("001");
            nom.setAttributeNode(attr);
            //The value of the element
            nom.appendChild(doc.createTextNode("Kazembe"));
            postnom.appendChild(doc.createTextNode("Kidinda"));
            prenom.appendChild(doc.createTextNode("Jesus"));
            adresse.appendChild(doc.createTextNode("1245,Makomeno"));
            date.appendChild(doc.createTextNode("21"));
            promotion.appendChild(doc.createTextNode("G3 SI"));

            identite.appendChild(nom);
            identite.appendChild(postnom);
            identite.appendChild(prenom);
            identite.appendChild(adresse);
            identite.appendChild(date);
            identite.appendChild(promotion);
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
 