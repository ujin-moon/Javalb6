public class phone<T, T2> {
    public T _YearOfCreate;
    public T2 _OperatingSystem;
    public T2 _Firma;
    public phone() {
    }
    public phone(T _YearOfCreate, T2 _OperatingSystem, T2 _Firma) {
        this._YearOfCreate = _YearOfCreate;
        this._OperatingSystem = _OperatingSystem;
        this._Firma = _Firma;
    }

    protected void _Print(phone obj) {
        System.out.printf("Год выпуска: " + obj._YearOfCreate + " Операционная система: " + obj._OperatingSystem + " Производитель: " + obj._Firma + "\n");
    }

    public Class GetClass() {
        return this.getClass();
    }
}
