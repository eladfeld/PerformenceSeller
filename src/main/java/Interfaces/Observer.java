package Interfaces;

import Services.User;

public interface Observer {
    public void updateAll(Observable o, User arg);

    public void addObservable(Observable o);
}
