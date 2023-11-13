package christmas.domain.payment.service;

import christmas.domain.menu.model.EntireMenu;
import java.util.Map;
import java.util.Map.Entry;

public class PaymentService {

    public int calculateOrderPrice(Map<EntireMenu, Integer> userMenu) {
        int orderPrice = 0;

        for (Entry<EntireMenu, Integer> menu : userMenu.entrySet()) {
            orderPrice += menu.getKey().getPrice() * menu.getValue();
        }
        return orderPrice;
    }

    public int calculateTotalDiscountPrice() {
    }

}
