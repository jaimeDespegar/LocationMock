package implementation.view;

import com.google.common.collect.Maps;
import views.PanelConfiguration;
import views.View;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ColorViewPanel implements PanelConfiguration {

    private JButton btnApply;
    private JComboBox<String> comboColors;
    private Map<String, Color> colors = Maps.newHashMap();

    public ColorViewPanel() {
        this.colors.put("RED", Color.RED);
        this.colors.put("GREEN", Color.GREEN);
        this.colors.put("BLUE", Color.BLUE);
        this.colors.put("YELLOW", Color.YELLOW);
    }

    @Override
    public JPanel buildPanel(View mainView) {
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 307, 123);
        panel.setLayout(null);

        comboColors = new JComboBox<>();
        comboColors.setBounds(133, 8, 164, 20);
        comboColors.addItem("RED");
        comboColors.addItem("GREEN");
        comboColors.addItem("BLUE");
        comboColors.addItem("YELLOW");
        panel.add(comboColors);

        btnApply = new JButton("Aplicar");
        btnApply.addActionListener(i -> this.changeBackgroundColor(mainView));
        btnApply.setBounds(108, 88, 89, 23);
        panel.add(btnApply);

        return panel;
    }

    private void changeBackgroundColor(View mainView) {
        mainView.getMainPanel().setBackground(this.colors.getOrDefault(comboColors.getSelectedItem(), Color.GRAY));
        mainView.repaint();
        mainView.closeViewConfiguration();
    }

}
