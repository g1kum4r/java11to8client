package clientmodel;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

public interface Model extends UnnamedPropertyChangeSubject {
    void send(String text);

    void getNumberOfPeople();

    void setUsername(String username);
}
