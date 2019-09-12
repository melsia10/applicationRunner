package be.technifutur.MVC;

import be.technifutur.MVC.applicationRunner.InteractiveApplication;

public class ApplicationMVC<T> implements InteractiveApplication {

    private Vue<T> vue;
    private Controleur<T> controleur;
    private T model;

    @Override
    public void start() {
        controleur.setModel(this.model);
        controleur.start();
        vue.setModel(model);
        vue.start();
    }

    @Override
    public StringBuilder getScreen() {
        return vue.getScreen();
    }

    @Override
    public boolean isFinish() {
        return controleur.isFinish();
    }

    @Override
    public void newInput(String input) {
        controleur.newInput(input);
    }

    @Override
    public boolean hasLastScreen() {
        return controleur.hasLastScreen();
    }

    @Override
    public void stop() {
        controleur.stop();
        vue.stop();
    }

    public void setModel(T model) {
        this.model = model;
    }

    public void setControleur(Controleur<T> controleur) {
        this.controleur = controleur;
    }

    public void setVue(Vue<T> vue) {
        this.vue = vue;
    }
}
