package bean;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLjdomDishWriter {
    public XMLjdomDishWriter() {
    }

    public static void main(String[] args) throws IOException {

        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(1, "Pizza", 200, 300));
        dishes.add(new Dish(2, "Potatoes", 300, 200));
        dishes.add(new Dish(3, "Sushi", 225, 100));
        dishes.add(new Dish(4, "Lobster", 1000, 500));
        dishes.add(new Dish(5, "Soup of the day", 100, 250));

        String filename = "Dishes.xml";
        writeToXMLusingJDOM(dishes, filename);
    }

    private static void writeToXMLusingJDOM(List<Dish> dishes, String fileName) throws IOException {
        Document doc = new Document();
        doc.setRootElement(new Element("Dishes", Namespace.getNamespace("Dishes")));
        for (Dish dish : dishes) {
            Namespace.getNamespace("ID");
            Element dishElement = new Element("Dish");
            dishElement.setAttribute("ID", String.valueOf(dish.getId()));
            dishElement.addContent(new Element("Name", Namespace.getNamespace("Name")).setText(" ") + dish.getName());
            dishElement.addContent(new Element("Price", Namespace.getNamespace("Price")).setText(" " + dish.getPrice()));
            dishElement.addContent(new Element("Weight", Namespace.getNamespace("Weight")).setText(" " + dish.getWeight()));
        }
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        xmlOutputter.output(doc, new FileOutputStream(fileName));
    }
}

