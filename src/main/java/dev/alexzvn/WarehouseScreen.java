package dev.alexzvn;

import dev.alexzvn.frames.CreateProductDialog;
import dev.alexzvn.frames.EditProductDialog;
import dev.alexzvn.frames.ManagerFrame;
import dev.alexzvn.warehouse.Product;

import javax.swing.JFrame;

public class WarehouseScreen extends JFrame {
    final public static WarehouseScreen frame = new WarehouseScreen();

    final public ManagerFrame managerFrame = new ManagerFrame();

    protected WarehouseScreen() {
        setup();
    }

    protected void setup() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(managerFrame.getContentPane());
    }

    public void showCreateDialog() {
        CreateProductDialog dialog = new CreateProductDialog();

        dialog.setVisible(true);
    }

    public void showEditDialog(Product product) {
        EditProductDialog dialog = new EditProductDialog(product);

        dialog.setVisible(true);
    }
}
