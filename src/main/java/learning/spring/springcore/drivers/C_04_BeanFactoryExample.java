package learning.spring.springcore.drivers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import learning.spring.springcore.beans.Triangle;



/**
 * C_04_BeanFactoryExample where xmlBeanFactory is deprecated
 *
 */
public class C_04_BeanFactoryExample 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BeanFactory beanfactory = new XmlBeanFactory(new FileSystemResource("application-context.xml"));
        //triangle object is created and managed by spring container
        Triangle triangle = beanfactory.getBean(Triangle.class);
        triangle.draw();
        
    }
}
