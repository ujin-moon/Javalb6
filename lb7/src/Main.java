import java.util.*;
public class Main {
    public static ArrayList<phone> phones = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        _AddPhonesAuto();
        _PrintInfo<_IPhone> phonePrintInfo = new _PrintInfo<>();
       while (true){
           System.out.println("Выберите что хотите\n1-Поиск по смартфонам\n2-Добавление смартфона\n3-Сортировка по году\n4-Вывод\n5-Очистка консоли");
           int num = scan.nextInt();
           switch (num){
               case 1:{
                    _Search();
                    break;
               }
               case 2:{
                   _AddPhones();
                   break;
               }
               case 3:{
                   _Sort();
                   for (var item: phones) {
                       item._Print(item);
                   }
                   break;
               }
               case 4:{
                   for (var item : phones) {
                       if(item instanceof _IPhone<?>)
                       {
                           System.out.println("Iphone");
                           phonePrintInfo._PrintAll(item);

                       }
                       else
                       {
                           System.out.println("Телефон");
                           phonePrintInfo._PrintAll(item);
                       }
                   }
                   break;
               }
               case 5:{
                   _ClearConsole();
                   break;
               }

           }
       }

    }
    public static void _AddPhonesAuto(){
        phones.add(new phone(2015,"Android","Samsung"));
        phones.add(new phone(2016,"Android","Huawei"));
        phones.add(new phone(2016,"Android","Xiaomi"));
        phones.add(new _IPhone(2022,"IOS","Apple",64));
        phones.add(new _IPhone(2021,"IOS","Apple",128));
    }
    public static void _Search(){
        System.out.println("Введите поиск по критерию\n1-Производитель\n2-Операционная система\n3-Год выпсука");
        int num = scan.nextInt();
        if (num == 1){
            System.out.println("Введите производителя для  поиска: ");
            String _Name = scan.next();
            for (var item: phones) {
                if (item._Firma.toString().compareTo(_Name) == 0)
                    item._Print(item);
            }
        }
        if (num == 2){
            System.out.println("Введите операционную систему для  поиска: ");
            String _Group = scan.next();
            for (var item: phones) {
                if (item._OperatingSystem.toString().compareTo(_Group) == 0)
                    item._Print(item);
            }
        }
        if (num == 3){
            System.out.println("Введите год выпуска машины для поиска: ");
            int _Age = scan.nextInt();
            String _age = "" + _Age;
            for (var item: phones) {
                if (String.valueOf(item._YearOfCreate).compareTo(_age) == 0) {
                    item._Print(item);
                }
            }
        }


    }
    public static void _AddPhones(){
        System.out.println("Введите строку в формате:\nФирма,Операционная система,год выпсука");
        String _NewPhone = scan.next();
        String[] _New = _NewPhone.split(",");
        int _YearOfCreate = Integer.parseInt(_New[2]);
        String _operationgSystem = _New[1];
        String _Firma = _New[0];
        phones.add(new phone(_YearOfCreate,_operationgSystem,_Firma));
    }
    public static class _PrintInfo<T extends _IPhone> implements _MainInterface{
        T Phones = (T) new _IPhone<>();
        public void _PrintAll(Object obj) {
            if (obj instanceof phone<?,?>)
            {
                Phones._Print((phone) obj);
            }
            else
                Phones._Print((_IPhone) obj);


        }
    }
    interface _MainInterface{
        public  void _PrintAll(Object obj);
    }
    public static void _Sort(){
        phones.sort(Comparator.comparingInt(o -> (int) o._YearOfCreate));
    }
    public static void _ClearConsole(){
        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
    }
}
