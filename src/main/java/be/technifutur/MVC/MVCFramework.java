package be.technifutur.MVC;



public class MVCFramework extends ApplicationMVC {
    ApplicationMVC applicationMVC;
    public void start(MVCFactory app){
        applicationMVC.setControleur(app.getControleur());
        applicationMVC.setModel(app.getModel());
        applicationMVC.setVue(app.getVue());
        applicationMVC.start();
    }

}
