package implementation.view;

import views.MyViewComponent;
import views.View;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ColorComponent implements MyViewComponent {

    @Override
    public List<JComponent> getComponents(View context) {
        List<JComponent> components = new ArrayList<>();
        JButton button = new JButton("Settings");
        button.setBounds(325, 53, 100, 23);
        button.addActionListener(i -> new ViewConfiguration(context));
        components.add(button);
        return components;
    }

}