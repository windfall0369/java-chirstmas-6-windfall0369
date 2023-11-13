package christmas.domain.payment.model;

import christmas.domain.menu.model.EntireMenu;
import java.util.Map;
import java.util.Map.Entry;

public class Payment {

    int orderPrice;
    int discountPrice;
    int totalPrice;

    public int calculateOrderPrice(Map<EntireMenu, Integer> userMenu) {
        this.orderPrice = 0;

        for (Entry<EntireMenu, Integer> menu : userMenu.entrySet()) {
            orderPrice += menu.getKey().getPrice() * menu.getValue();
        }
        return orderPrice;
    }

    public int calculateTotalDiscountPrice() {
    }
}
