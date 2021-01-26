package app;

abstract class Menu {
    private final String[] options;
    private final boolean isSubmenu;

    Menu(String[] options, boolean isSubmenu) {
        this.options = options;
        this.isSubmenu = isSubmenu;
    }

    void showOptions() {
        StringBuilder formattedOptions = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            formattedOptions.append(String.format("%s. %s \n", i + 1, options[i]));
        }
        System.out.printf("%s%s. %s%n", formattedOptions.toString(), options.length+1, isSubmenu ? "Back" : "Exit");
    }

    protected int getOptionsLength() {
        return options.length;
    }
}
