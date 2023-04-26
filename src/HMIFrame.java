import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HMIFrame extends JFrame implements ActionListener {
    private WarehousePanel pWarehouse;
    private BoxesPanel pBoxes;
    private OrderPanel pOrder;

    private SelectOrderDialog dSelectOrder;
    private EditOrderDialog	dEditOrder;

    private JButton bSelectOrder;
    private JButton bEditOrder;
    private JButton bPickUpOrder;
    private JButton bPrintPdf;
    
    private Order order;
    
    public HMIFrame() {
        // basic setup
        setTitle("HMI NerdyGadgets");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // warehouse panel
        JLabel lWarehouse = new JLabel("Weergave robot");
        add(lWarehouse);
        pWarehouse = new WarehousePanel();
        add(pWarehouse);

        // boxes panel
        JLabel lBoxes = new JLabel("Dozen");
        add(lBoxes);
        pBoxes = new BoxesPanel();
        add(pBoxes);

        // order panel
        JLabel lOrder = new JLabel("Order");
        add(lOrder);

        pOrder = new OrderPanel();
        add(pOrder);

        // buttons
        bSelectOrder = new JButton("Selecteer order");
        add(bSelectOrder);
        bSelectOrder.addActionListener(this);
        bEditOrder = new JButton("Wijzig order");
        add(bEditOrder);
        bEditOrder.addActionListener(this);
        bPickUpOrder = new JButton("Haal order op");
        add(bPickUpOrder);
        bPickUpOrder.addActionListener(this);
        bPrintPdf = new JButton("Print pakbon");
        add(bPrintPdf);
        bPrintPdf.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bEditOrder) {
            dEditOrder = new EditOrderDialog(this, true, order);
            dEditOrder.setVisible(true);
        } else if (e.getSource() == bSelectOrder) {
            dSelectOrder = new SelectOrderDialog(this, true);
            pOrder.setOrder(dSelectOrder.getSelectedOrder());
            dSelectOrder.dispose();
        } else if (e.getSource() == bPickUpOrder) {
            // TODO pick up order
        } else if (e.getSource() == bPrintPdf) {
            // TODO print pdf
        }
    }
}
