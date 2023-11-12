package christmas.domain.menu.controller;

import christmas.domain.menu.view.inputView.MenuInputView;
import christmas.domain.menu.view.outputView.MenuOutputView;

public class MenuController {

    private final MenuInputView inputView = new MenuInputView();
    private final MenuOutputView outputView = new MenuOutputView();

    public void chooseMenu() {
        outputView.printMenu();
        inputView.getUserMenu();

    }


}
