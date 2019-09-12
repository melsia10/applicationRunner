package be.technifutur.MVC;

public interface Vue<T> {

    void start();
    StringBuilder getScreen();
    void stop();
    void setModel(T model);
}
