package bean;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ParsingStAX {

    public static void main(String[] args) {

        final String fileName = "test.xml";

        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));

            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    System.out.print(xmlr.getLocalName());
                } else if (xmlr.isEndElement()) {
                    System.out.println();
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    System.out.print(" " + xmlr.getText());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
