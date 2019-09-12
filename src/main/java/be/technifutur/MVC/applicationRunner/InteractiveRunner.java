package be.technifutur.MVC.applicationRunner;

public class InteractiveRunner implements Runnable {
    private InteractiveApplication application;
    private Environment environment = new ConsoleEnvironment();



    @Override
    public void run() {
        if (application != null) {
            application.start();
            while (!application.isFinish()) {
                environment.print(application.getScreen().toString());
                application.newInput(environment.nextLine());
            }
            if (application.hasLastScreen()) {
                environment.print(application.getScreen().toString());
            }
            application.stop();
        }
    }

    public InteractiveApplication getApplication() {
        return application;
    }

    public void setApplication(InteractiveApplication application) {
        this.application = application;
    }
    public void setEnvironment(Environment environment) {
        if(environment == null){
            throw new NullEnvironmentException();
        }this.environment = environment; }
}
