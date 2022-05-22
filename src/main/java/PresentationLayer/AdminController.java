package PresentationLayer;

import BussinesLayer.DeliveryService;
import BussinesLayer.MenuItem;
import BussinesLayer.Order;
import DataLayer.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminController {

    private AdminView adminView;
    private DeliveryService deliveryService;


    public AdminController(AdminView adminView, DeliveryService deliveryService){
        this.adminView = adminView;
        this.deliveryService = deliveryService;
        adminView.addImportProductsListener(new ImportProductsListener());
        adminView.addViewProductsListener(new ViewProductsListener());
        adminView.addAddNewProductListener(new AddProductListener());
        adminView.addModifyProductListener(new ModifyProductListener());
        adminView.addDeleteProductListener(new DeleteProductListener());
        adminView.addCompositeListener(new CreateCompositeProductListener());
        adminView.addFirstReportListener(new FirstReportGeneratorListener());
        adminView.addSecondReportListener(new SecondReportGeneratorListener());
        adminView.addThirdReportListener(new ThirdReportGeneratorListener());
        adminView.addFourthReportListener(new FourthReportGeneratorListener());
        adminView.setVisible(true);
    }

    private class ImportProductsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.importProducts();
            adminView.makeJTable();
        }
    }

    private class ViewProductsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.makeJTable();
        }

    }

    private class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminView.getTitle();
            double rating = Double.parseDouble(adminView.getRating());
            int calories = Integer.parseInt(adminView.getCalories());
            int protein = Integer.parseInt(adminView.getProtein());
            int fat = Integer.parseInt(adminView.getFat());
            int sodium = Integer.parseInt(adminView.getSodium());
            int price = Integer.parseInt(adminView.getPrice());
            if (deliveryService.addProduct(title, rating, calories, protein, fat, sodium, price)) {
                adminView.showMessage("The product was succesfully added");
                adminView.setTitlee(null);
                adminView.setRating(null);
                adminView.setCalories(null);
                adminView.setProtein(null);
                adminView.setFat(null);
                adminView.setSodium(null);
                adminView.setPrice(null);
            } else {
                adminView.showMessage("The product wasn't added.Try again");
            }
        }
    }

    private class ModifyProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminView.getTitle();
            double rating = Double.parseDouble(adminView.getRating());
            int calories = Integer.parseInt(adminView.getCalories());
            int protein = Integer.parseInt(adminView.getProtein());
            int fat = Integer.parseInt(adminView.getFat());
            int sodium = Integer.parseInt(adminView.getSodium());
            int price = Integer.parseInt(adminView.getPrice());
            if (deliveryService.modifyProduct(title, rating, calories, protein, fat, sodium, price)) {
                adminView.showMessage("The product was succesfully modified");
                adminView.setTitlee(null);
                adminView.setRating(null);
                adminView.setCalories(null);
                adminView.setProtein(null);
                adminView.setFat(null);
                adminView.setSodium(null);
                adminView.setPrice(null);
            } else {
                adminView.showMessage("The product wasn't modified.Try again");
            }
        }

    }

    private class DeleteProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminView.getTitle();
            if (deliveryService.deleteProduct(title)) {
                adminView.showMessage("The product was succesfully deleted");
                adminView.setTitlee(null);
            } else {
                adminView.showMessage("The product wasn't deleted. Write another title");
            }
        }
    }

    private class CreateCompositeProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CompositeProductView compositeProductView = new CompositeProductView(deliveryService);
            compositeProductView.setVisible(true);
        }
    }

    private class FirstReportGeneratorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int startHour = Integer.parseInt(adminView.getStartHour());
            int endHour = Integer.parseInt(adminView.getEndHour());
            List<Order> result = deliveryService.generateReport1(startHour,endHour);
            adminView.makeFirstReportJTable(result);
        }
    }

    private class SecondReportGeneratorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int nrTimesOrdered = Integer.parseInt(adminView.getNumberTimes1());
            List<MenuItem> result = deliveryService.generateReport2(nrTimesOrdered);
            adminView.makeSecondReportJTable(result);
        }
    }

    private class ThirdReportGeneratorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int nrTimesOrdered = Integer.parseInt(adminView.getNumberTimes2());
            int amount = Integer.parseInt(adminView.getAmount());
            List<User> result = deliveryService.generateReport3(nrTimesOrdered,amount);
            adminView.makeThirdReportJTable(result);
        }
    }


    private class FourthReportGeneratorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int day = Integer.parseInt(adminView.getDay());
            List<MenuItem> result = deliveryService.generateReport4(day);
            adminView.makeSecondReportJTable(result);
        }
    }
}
