package dao;

public interface EssenceDAO<T> {
    void add(T essence);
    T getId (Class<T> essence,int id);
    void all();
    void mod(T essence);
    void remove(T essence);
}
