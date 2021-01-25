package app;

import java.util.Scanner;

abstract class Menu {
    private final String[] options;
    private final boolean submenu;
    final static Scanner scanner = new Scanner(System.in);

    public Menu(String[] options, boolean submenu) {
        this.options = options;
        this.submenu = submenu;
    }

    void showOptions() {
        StringBuilder formattedOptions = new StringBuilder();
        for (int i = 0; i < this.options.length; i++) {
            formattedOptions.append(String.format("%s. %s \n", i + 1, this.options[i]));
        }
        System.out.printf("%s%s. %s%n", formattedOptions.toString(), this.options.length+1, this.submenu ? "Back" : "Exit");
    }

    protected int getOptionsLength() {
        return this.options.length;
    }
}
