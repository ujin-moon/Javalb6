public class _IPhone<T extends Integer> extends phone {
    public T _Memory;
    public _IPhone() {
    }
    public _IPhone(Object _YearOfCreate, Object _OperatingSystem, Object _Firma, T _Memory) {
        super(_YearOfCreate, _OperatingSystem, _Firma);
        this._Memory = _Memory;
    }
    public void _Print(_IPhone obj) {
        System.out.printf("Год выпуска: " + obj._YearOfCreate + " Операционная система: " + obj._OperatingSystem + " Производитель: " + obj._Firma + " Память: " + obj._Memory + "\n");
    }

    public Class GetClass() {
        return this.getClass();
    }
}
