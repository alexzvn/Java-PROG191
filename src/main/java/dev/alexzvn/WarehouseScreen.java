package dev.alexzvn;

import dev.alexzvn.frames.CreateProductDialog;
import dev.alexzvn.frames.EditProductDialog;
import dev.alexzvn.frames.LoginFrame;
import dev.alexzvn.frames.ManagerFrame;
import dev.alexzvn.warehouse.Product;

import javax.swing.JFrame;

public class WarehouseScreen extends JFrame {
    final public static WarehouseScreen frame = new WarehouseScreen();

    final public ManagerFrame managerFrame = new ManagerFrame();

    protected WarehouseScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        switchToLoginFrame();
    }

    public void switchToManagerFrame() {
        setSize(1000, 700);
        setContentPane(managerFrame.getContentPane());
        pack();
    }

    public void switchToLoginFrame() {
        setSize(500, 400);
        setContentPane(new LoginFrame().getContentPane());
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
