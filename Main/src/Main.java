import java.util.*;
import java.io.*;

class Main{
    public static int[] _ArrayFirst;
    public static ArrayList<Double> _ArraySecond = new ArrayList<>();
    public static Scanner _Scanner = new Scanner(System.in);
    public static Random _Random = new Random();
    public static class _GenerateArray implements Runnable,_PrintInfo{
        private int num;
        public _GenerateArray(int n){
            this.num = n;
            Thread _GenerateArray = new Thread(this,"Дочерний поток " + num);
            System.out.println("Дочерний поток " + num + " создан!");
            num = num+1;
            System.out.println("Дочерний поток " + num + " создан!");
            num = num+1;
            System.out.println("Дочерний поток " + num + " создан!");
            _GenerateArray.start();
        }
        @Override
        public void run()
        {
            _ArrayFirst = new int[_Random.nextInt(100,10000)];
            for (int i = 0; i < _ArrayFirst.length; i++) {
                _ArrayFirst[i] = _Random.nextInt(100,10000);
            }
        }

        public void _PrintInfo() {
            System.out.println("Случайный массив:");
            for (int i = 0; i < _ArrayFirst.length; i++) {
                System.out.println(i + "-ый элемент массива: " + _ArrayFirst[i] + "\n");
            }

        }
    }
    public static class _ArrayHandling implements Runnable,_PrintInfo{
        private Thread _ArrayHandling;
        public _ArrayHandling(int d) {
            _ArrayHandling = new Thread(this, "Поток вычисления суммы элементов кратных 5, но не кратных 2");
            _ArrayHandling.start();
        }

        @Override
        public void run() {
            int _Count = 0;
            int Summa = 0;
            for (int i = 0; i < _ArrayFirst.length; i++) {
                if (_ArrayFirst[i] % 5 == 0 && _ArrayFirst[i] % 2 != 0)
                {
                    Summa += _ArrayFirst[i];
                }
            }
            System.out.println("Сумма элементов кратных 5 и не кратных 3 = " + Summa + "\n");
        }

        public void _PrintInfo() {
        }


        public Thread get_ArrayHandling()  {return _ArrayHandling;}


    }
    public static class _InputTextFile{
        int Summa = 0;
        public boolean _TextFile() throws IOException {
            try(FileWriter writer = new FileWriter("TextFile.txt", false)){
                for (int i = 0; i < _ArrayFirst.length; i++) {
                    Summa += _ArrayFirst[i];
                }
                writer.write("Сумма элементов кратных 5 и не кратных 3 = " + Summa + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            FileReader reader = new FileReader("TextFile.txt");
            int c;
            boolean f = false;
            while((c=reader.read())!=-1){
                f = true;
            }
            return f;
        }

    }
    public static void main(String[] args) {
        System.out.println("Введите номер дочернего потока:");
        int _Num = _Scanner.nextInt();
        _GenerateArray generateArray = new _GenerateArray(_Num);
        _ArrayHandling arrayHandling = new _ArrayHandling(1);
        generateArray.run();
        arrayHandling.run();
        generateArray.run();
        arrayHandling.run();
        _InputTextFile inputTextFile = new _InputTextFile();
        try {
            inputTextFile._TextFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    interface _PrintInfo{
        public void _PrintInfo();
    }
}
