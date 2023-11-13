package christmas.domain.payment.controller;

import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.model.Payment;
import christmas.domain.payment.service.PaymentService;
import christmas.domain.payment.view.outputView.PaymentOutputView;
import java.util.Map;

public class PaymentController {

    private final Payment payment = new Payment();
    private final PaymentOutputView outputView = new PaymentOutputView();
    private final PaymentService paymentService = new PaymentService();

    public int getOrderPrice(Map<EntireMenu, Integer> userMenu) {
        int orderPrice = paymentService.calculateOrderPrice(userMenu);
        outputView.printOrderPrice(orderPrice);
        return orderPrice;
    }
}
