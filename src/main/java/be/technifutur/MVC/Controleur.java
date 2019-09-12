package be.technifutur.MVC;

public interface Controleur<T> {

    void start();
    boolean isFinish();
    void newInput(String input);
    boolean hasLastScreen();
    void stop();

    void setModel(T model);
}
