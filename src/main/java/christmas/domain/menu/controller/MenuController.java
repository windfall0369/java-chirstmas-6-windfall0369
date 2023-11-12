package christmas.domain.menu.controller;

import christmas.domain.menu.view.inputView.MenuInputView;
import christmas.domain.menu.view.outputView.MenuOutputView;
import java.util.Map;

public class MenuController {

    private final MenuInputView inputView = new MenuInputView();
    private final MenuOutputView outputView = new MenuOutputView();

    public Map<String, Integer> chooseMenu() {
        outputView.printMenu();
        return inputView.getUserMenu();
    }
}
