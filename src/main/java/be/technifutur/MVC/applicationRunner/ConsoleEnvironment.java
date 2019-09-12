package be.technifutur.MVC.applicationRunner;

import java.util.Scanner;

public class ConsoleEnvironment implements Environment {

    private Scanner scan = new Scanner((System.in));

    @Override
    public void print(CharSequence out) {
        System.out.print(out);
    }

    @Override
    public String nextLine() {
        return this.scan.nextLine();
    }
}
