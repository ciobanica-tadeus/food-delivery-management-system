package PresentationLayer;

import BussinesLayer.DeliveryService;
import BussinesLayer.MenuItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientController {

    private ClientView clientView;
    private DeliveryService deliveryService;
    private String user;

    public ClientController (ClientView clientView, DeliveryService deliveryService, String user){
        this.clientView = clientView;
        this.deliveryService = deliveryService;
        this.user = user;
        clientView.addSearchByTitleListener(new SearchByTitleListener());
        clientView.addSearchByRatingListener(new SearchByRatingListener());
        clientView.addSearchByCaloriesListener(new SearchByCaloriesListener());
        clientView.addSearchByProteinsListener(new SearchByProteinsListener());
        clientView.addSearchByFatListener(new SearchByFatsListener());
        clientView.addSearchBySodiumListener(new SearchBySodiumListener());
        clientView.addSearchByPriceListener(new SearchByPriceListener());
        clientView.addResetSearchListener(new ResetSearchListener());
        clientView.addSubmitOrderListener(new SubmitOrderListener());
        clientView.setVisible(true);
    }

    class SearchByTitleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<MenuItem> menuItemList = deliveryService.searchProductsByTitle(clientView.getItems(),clientView.getTitlee());
            clientView.showJList(menuItemList);
        }
    }

    class SearchByRatingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.showJList(deliveryService.searchProductsByRating(clientView.getItems(),clientView.getMinRating(), clientView.getMaxRating()));
        }
    }

    class SearchByCaloriesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.showJList(deliveryService.searchProductsByCalories(clientView.getItems(), clientView.getMinCalories(), clientView.getMaxCalories()));

        }
    }

    class SearchByProteinsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.showJList(deliveryService.searchProductsByProteins(clientView.getItems(), clientView.getMinProteins(), clientView.getMaxProteins()));
        }
    }

    class SearchByFatsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.showJList(deliveryService.searchProductsByFat(clientView.getItems(), clientView.getMinFat(), clientView.getMaxFat()));
        }
    }

    class SearchBySodiumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.showJList(deliveryService.searchProductsBySodium(clientView.getItems(), clientView.getMinSodium(), clientView.getMaxSodium()));
        }
    }

    class SearchByPriceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.showJList(deliveryService.searchProductsByPrice(clientView.getItems(), clientView.getMinPrice(), clientView.getMaxPrice()));
        }
    }

    class ResetSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.showJList(deliveryService.getMenuItems());
        }
    }

    class SubmitOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.createOrder(user, clientView.getSelectedProducts());
            clientView.showMessage("Comanda adaugata cu succes");

        }
    }
}
