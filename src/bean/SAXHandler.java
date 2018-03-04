package bean;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class SAXHandler extends DefaultHandler {

    private String elementName;
    private Dish dish;
    private List<Dish> dishList = new ArrayList<>();


    @Override
    public void startDocument() throws SAXException {
        System.out.println("start parsing...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end parsing...");
    }


    @Override
    public void startElement(String nameSpace, String localName, String qName, Attributes attr) {
        elementName = qName;
        if (elementName.equals("Dish")) {
            dish = new Dish();
        }
    }

    @Override
    public void endElement(String nameSpace, String localName, String qName) throws SAXException {
        if (qName.equals("Dish")) {
            dishList.add(dish);
        }
        elementName = "";
    }


    @Override
    public void characters(char[] ch, int start, int end) {
        String value = new String(ch, start, end);
        switch (elementName) {
            case "ID":
                dish.setId(Integer.parseInt(value));
                break;
            case "Name":
                dish.setName(value);
                break;
            case "Price":
                dish.setPrice(Integer.parseInt(value));
                break;
            case "Weigh":
                dish.setWeight(Integer.parseInt(value));
                break;
        }
    }

    public List<Dish> getDishList() {
        return dishList;
    }
}
