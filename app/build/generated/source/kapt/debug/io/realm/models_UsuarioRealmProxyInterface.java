package io.realm;


public interface models_UsuarioRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$nombre();
    public void realmSet$nombre(String value);
    public String realmGet$password();
    public void realmSet$password(String value);
    public String realmGet$email();
    public void realmSet$email(String value);
    public double realmGet$saldo();
    public void realmSet$saldo(double value);
    public RealmList<models.Gasto> realmGet$listaGastos();
    public void realmSet$listaGastos(RealmList<models.Gasto> value);
}
