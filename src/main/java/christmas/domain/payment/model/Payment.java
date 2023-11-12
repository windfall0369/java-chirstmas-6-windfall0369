package christmas.domain.payment.model;

import christmas.domain.menu.model.EntireMenu;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Payment {

    int orderPrice;
    int discountPrice;
    int totalPrice;

    public Map<EntireMenu, Integer> findMenuName(Map<String, Integer> userMenu) {
        Map<EntireMenu, Integer> userMenuNameAndAmount = new HashMap<>();

        for (Entry<String, Integer> menu : userMenu.entrySet()) {
            EntireMenu menuName = matchMenuName(menu.getKey());
            Integer amount = menu.getValue();
            userMenuNameAndAmount.put(menuName, amount);
        }
        return userMenuNameAndAmount;
    }

    private EntireMenu matchMenuName(String menu) {
        for (EntireMenu menuName : EntireMenu.values()) {
            if (menu.equals(menuName.getName())) {
                return menuName;
            }
        }
        return null;
    }
}
