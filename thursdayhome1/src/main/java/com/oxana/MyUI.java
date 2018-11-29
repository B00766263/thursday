package com.oxana;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
       Label label = new Label("Hello", ContentMode.HTML);
        String text = "Whoo";
        Notification n = new Notification(text);
        Button button = new Button("add new");

        button.addClickListener(e -> {
           // int x = Integer.parseInt(num1.getValue());
            //int y = Integer.parseInt(num2.getValue());
            //Notification.show(""+(x+y));
            //layout.addComponent(new Label(""+(x+y)));
            label.setValue("<h1>HELLO!!!!!</h1>");
            n.show(text);
                   });
        button.setHeight("200px");
        button.setWidth("200px");
        ComboBox<String> cb = new ComboBox<String>("Title");
        cb.setItems("Mrs", "Ms", "Mr", "Dr", "Fr");
        cb.setPlaceholder("Ms");

        Slider s = new Slider(1.0, 300.0, 10);
        
        
         layout.setSpacing(true);
        layout.addComponents(label, cb, button,s);
      

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
