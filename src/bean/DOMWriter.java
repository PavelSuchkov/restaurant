package bean;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DOMWriter {
    public static void main(String[] args) throws Exception {

        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(1, "Pizza", 200, 300));
        dishes.add(new Dish(2, "Potatoes", 300, 200));
        dishes.add(new Dish(3, "Sushi", 225, 100));
        dishes.add(new Dish(4, "Lobster", 1000, 500));
        dishes.add(new Dish(5, "Soup of the day", 100, 250));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element menu = document.createElement("Menu");

        document.appendChild(menu).setTextContent("Menu");

        for (Dish i : dishes) {

            Element dish = document.createElement("Dish");
            Element ID = document.createElement("ID");
            Element name = document.createElement("Name");
            Element price = document.createElement("Price");
            Element weight = document.createElement("Weigh");
            menu.appendChild(dish).setTextContent("Dishes");
            dish.appendChild(ID).setTextContent(String.valueOf(i.getId()));
            dish.appendChild(name).setTextContent(i.getName());
            dish.appendChild(price).setTextContent(String.valueOf(i.getPrice()));
            dish.appendChild(weight).setTextContent(String.valueOf(i.getWeight()));
        }
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes"); // формирует построение документа в столбец
        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("test.xml")));



    }
}
