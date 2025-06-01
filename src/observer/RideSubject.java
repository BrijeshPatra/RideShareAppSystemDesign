package observer;

public interface RideSubject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(String message);
}
