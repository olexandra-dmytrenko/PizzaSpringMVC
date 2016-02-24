package ua.rd.deliveryservice.infrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author andrii
 */
public class JavaConfigApplicationContext implements ApplicationContext {

    private final Config config;
    private final Map<String, Object> beans = new HashMap<>();

    public JavaConfigApplicationContext(Config config) {
        this.config = config;
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        Class<?> type = config.getImpl(beanName);
        Object bean = beans.get(beanName);

        if (bean != null) {
            return bean;
        }

        BeanBuilder builder = new BeanBuilder(type);
        builder.createBean();
        builder.callPostCreateAnnotatedMethod();
        builder.callInitMethod();
        builder.createBeanProxy();
        bean = builder.build();

        beans.put(beanName, bean);

        return bean;
    }

    class BeanBuilder {

        private final Class<?> type;
        private Object bean;

        public BeanBuilder(Class<?> type) {
            this.type = type;
        }

        public void createBean() throws Exception {
            Constructor<?> constructor = type.getConstructors()[0];

            if (constructor.getParameterCount() == 0) {
                bean = type.newInstance();
            } else {
                bean = newInstanceWithParameters(constructor);
            }
        }

        private Object newInstanceWithParameters(Constructor<?> constructor) throws Exception {
            Parameter[] parameters = constructor.getParameters();

            Object[] paramsVal = new Object[parameters.length];

            for (int i = 0; i < parameters.length; i++) {
                Class<?> paramType = parameters[i].getType();
                String beanName = getBeanNameByType(paramType);
                paramsVal[i] = getBean(beanName);
            }

            return constructor.newInstance(paramsVal);
        }

        private String getBeanNameByType(Class<?> paramType) {
            //System.out.println(paramType);
            String paramTypeName = paramType.getSimpleName();
            String localBeanName
                    = Character.toLowerCase(paramTypeName.charAt(0)) + paramTypeName.substring(1);
            return localBeanName;
        }

        public void callInitMethod() throws Exception {
            Class<?> clazz = bean.getClass();
            Method method;
            try {
                method = clazz.getMethod("init");
            } catch (NoSuchMethodException ex) {
                return;
            }
            method.invoke(bean);
        }

        private void callPostCreateAnnotatedMethod() throws Exception {
            Class<?> clazz = bean.getClass();
            for (Method method : clazz.getMethods()) {
                if (method.getAnnotation(PostCreate.class) != null) {
                    method.invoke(bean);
                }
            }                    
        }

        public void createBeanProxy() {
            bean = new ProxyForBenchmarkAnnotation().proxyObjForBenchmarkAnnotation(bean);
        }

        public Object build() {
            return bean;
        }
    }

}
