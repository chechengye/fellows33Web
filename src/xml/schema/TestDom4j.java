package xml.schema;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class TestDom4j {

    @Test
    public void testDom4j(){

        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read("src/student.xml");
            Element rootElement = document.getRootElement();
            System.out.println(rootElement.getName());
            List<Element> elements = rootElement.elements();
            for(Element e : elements){
                if(e.getName().equals("name")){
                    if(e.attributeValue("id").equals("stu1")){
                        System.out.println("姓名:" + e.getText());
                    }
                   // System.out.println("姓名:" + e.getText());
                }

                if(e.getName().equals("age")){
                    System.out.println("年龄:" + e.getText());
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
