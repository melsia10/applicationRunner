package be.technifutur.MVC.applicationRunner;

public interface InteractiveApplication {
    public void start();
    public StringBuilder getScreen();
    public boolean isFinish();
    public void newInput(String input);
    public boolean hasLastScreen();
    public void stop();}
