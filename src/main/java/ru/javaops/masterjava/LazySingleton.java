package ru.javaops.masterjava;

public class LazySingleton {
    // volatile - объект который не сконструирован - не опубликуется.
    private static volatile LazySingleton instance;

    public static LazySingleton getInstance() {
        if (instance == null) {
            //getInstance - static method синхронизируемся вместо инстанса объекта (this)
            // по инстансу объекта (ClassName)
            synchronized (LazySingleton.class) {
                // double check locking pattern - его часто называют антипаттерном,
                // т.к. есть initialization-on-demand holder idiom - делается внутренний статический класс
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    private LazySingleton() {
        // уже не равен null, но еще не сконструирован до конца.
        // без volatile возвращает другому потоку инстанс не сконструированный
        // альтернатива volatile - i - поле final. Пока все final-поля не проинициализируются, никто ссылку
        // на несконструированный объект не получит
        int i = 5 + 8;
    }
}
