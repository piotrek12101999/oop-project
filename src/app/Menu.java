package app;

import models.DataBase;
import models.Item;
import utils.GetStringFromUserUtil;

abstract class Menu {
    private final String[] options;
    private final boolean isSubmenu;
    private final DataBase dataBase;

    Menu(String[] options, boolean isSubmenu, DataBase dataBase) {
        this.options = options;
        this.isSubmenu = isSubmenu;
        this.dataBase = dataBase;
    }

    void showOptions() {
        StringBuilder formattedOptions = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            formattedOptions.append(String.format("%s. %s \n", i + 1, options[i]));
        }
        System.out.printf("%s%s. %s%n", formattedOptions.toString(), options.length+1, isSubmenu ? "Back" : "Exit");
    }

    protected void deleteItem() {
        String id = GetStringFromUserUtil.getData("Enter id", false, null);
        Item deletedItem = dataBase.delete(id);
        if (deletedItem != null){
            System.out.printf("Item with ID: %s, has been deleted%n", deletedItem.getId());
        }
    }

    protected int getOptionsLength() {
        return options.length;
    }
}
