package christmas.domain.payment.controller;

import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.model.Payment;
import christmas.domain.payment.view.outputView.PaymentOutputView;
import java.util.Map;
import java.util.Map.Entry;

public class PaymentController {

    private final Payment payment = new Payment();
    private final PaymentOutputView outputView = new PaymentOutputView();

    public int calculateOrderPrice(Map<String, Integer> userMenu) {
        int orderPrice = 0;
        Map<EntireMenu, Integer> menuName = payment.findMenuName(userMenu);

        for (Entry<EntireMenu, Integer> menu : menuName.entrySet()) {
            orderPrice += menu.getKey().getPrice() * menu.getValue();
        }
        outputView.printOrderPrice(orderPrice);
        return orderPrice;
    }

}
