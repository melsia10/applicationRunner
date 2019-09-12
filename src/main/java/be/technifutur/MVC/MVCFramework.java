package be.technifutur.MVC;


import be.technifutur.MVC.applicationRunner.InteractiveRunner;

public class MVCFramework<T> {
    ApplicationMVC applicationMVC = new ApplicationMVC();
    public void start(MVCFactory app){
        InteractiveRunner interactiveRunner = new InteractiveRunner();
        applicationMVC.setControleur(app.getControleur());
        applicationMVC.setModel(app.getModel());
        applicationMVC.setVue(app.getVue());
        applicationMVC.start();
        interactiveRunner.setApplication(applicationMVC);
        interactiveRunner.run();
    }

}
