package christmas.domain.discount.controller;

import christmas.domain.discount.service.DiscountService;
import christmas.domain.event.model.EventChecker;
import christmas.domain.menu.model.EntireMenu;
import java.util.List;
import java.util.Map;

public class DiscountController {

    private final DiscountService discountService = new DiscountService();

    public List<Integer> getDiscountPrice(Map<EntireMenu, Integer> userMenu, EventChecker events) {
        return discountService.calculateDiscountPrice(userMenu, events);

    }
}
