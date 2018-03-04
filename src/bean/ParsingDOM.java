package bean;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParsingDOM {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("test.xml"));

        Element element = document.getDocumentElement();// получение корневого элемента <Menu>
        System.out.println(document.getDocumentElement() + " : ");
        parseElements(element.getChildNodes());

    }

    static void parseElements(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) { // Выводим в консоль все элементы <Menu>
            if (nodeList.item(i) instanceof Element) {
                String value = "";

                if (!nodeList.item(i).getTextContent().trim().isEmpty() &&
                        !((Text) nodeList.item(i).getFirstChild()).getData().trim().isEmpty() &&
                        !((Text) nodeList.item(i).getFirstChild()).getData().trim().equals("\n")) {

                    Text text = (Text) nodeList.item(i).getFirstChild();

                    value += " = " + text.getData().trim();
                    System.out.println(((Element) nodeList.item(i)).getTagName() + value);

                }


                if (nodeList.item(i).hasChildNodes()) {
                    parseElements(nodeList.item(i).getChildNodes());

                }

            }
        }
    }
}