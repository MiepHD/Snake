package snake;

class Runner implements Runnable {
    private UserInterface ui;

    Runner(UserInterface ui) {
        this.ui = ui;
    }

    public void run() {
        this.ui.update();
    }
}
