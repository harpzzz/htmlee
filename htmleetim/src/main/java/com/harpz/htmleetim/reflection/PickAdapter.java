package com.harpz.htmleetim.reflection;

import com.harpz.htmleetim.annotations.Pick;

import org.jsoup.nodes.Element;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Neha Thakur on 10/28/2017.
 */

public class PickAdapter<T> {


    Object mObject;

    public T read(Element element, String classOfName) {

        try {
            Class mClass = Class.forName(classOfName);


           mObject = mClass.newInstance();



            Field[] fd = mClass.getDeclaredFields();

            for(int i=0; i< fd.length;i++) {

                    Field field = fd[i];

                    if (field.isAnnotationPresent(Pick.class)) {
                        field.setAccessible(true);

                        Annotation annotation = field.getAnnotation(Pick.class);

                            Pick iPick = (Pick) annotation;

                          field.set(mObject,element.select(iPick.value()).text());


                    }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        return (T) mObject;

    }
}
