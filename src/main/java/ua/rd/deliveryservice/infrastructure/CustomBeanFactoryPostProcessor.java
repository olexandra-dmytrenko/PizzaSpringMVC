package ua.rd.deliveryservice.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

/**
 *
 * @author andrii
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("newCustomer");
        ConstructorArgumentValues argumentValues 
                = bd.getConstructorArgumentValues();
        System.out.println(argumentValues.getArgumentCount());
        System.out.println(argumentValues.getArgumentValue(0, null).getValue());
        argumentValues.getArgumentValue(0, null).setValue("Nik");
        bd.setScope("singleton");
    }
    
}
