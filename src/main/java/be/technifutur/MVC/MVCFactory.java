package be.technifutur.MVC;

public interface MVCFactory<T> {
    T getModel();
    Controleur<T> getControleur();
    Vue<T> getVue();
}
