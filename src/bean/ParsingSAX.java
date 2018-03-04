package bean;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ParsingSAX {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setValidating(true);
        SAXHandler saxHandler = new SAXHandler();

        try {
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(new File("test.xml"), saxHandler);
        }
        catch (ParserConfigurationException|SAXException e) {
            e.printStackTrace();
        }

        for (Dish dish : saxHandler.getDishList()){
            System.out.println(dish);
        }

    }
}
