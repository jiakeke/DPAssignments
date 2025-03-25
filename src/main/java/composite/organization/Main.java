package composite.organization;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {

    public static String formatXML(String xml) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        StreamSource source = new StreamSource(new StringReader(xml));
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        transformer.transform(source, result);
        return writer.toString();
    }

    public static void main(String[] args) throws TransformerException {
        Department engineering = new Department("Engineering");
        engineering.add(new Employee("John Doe", 1200));
        engineering.add(new Employee("Jane Doe", 1500));
        engineering.add(new Employee("Alice", 2000));
        engineering.add(new Employee("Bob", 1800));

        Department administration = new Department("Administration");
        administration.add(new Employee("Charlie", 1600));
        administration.add(new Employee("Daisy", 1900));

        Department it = new Department("IT");
        it.add(engineering);
        it.add(administration);

        Department marketing = new Department("Marketing");
        marketing.add(new Employee("Carol", 1000));
        marketing.add(new Employee("Dave", 1200));

        Department sales = new Department("Sales");
        sales.add(new Employee("Eve", 1100));
        sales.add(new Employee("Frank", 1300));

        Department company = new Department("Company");
        company.add(it);
        company.add(marketing);
        company.add(sales);

        System.out.println("Total salary: " + company.getSalary());

        String xml = company.getXML();
        System.out.println(formatXML(xml));
    }
}
