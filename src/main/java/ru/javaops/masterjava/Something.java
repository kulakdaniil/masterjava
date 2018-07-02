package ru.javaops.masterjava;

public class Something {

    //initialization-on-demand holder idiom

    private Something() {
    }

    private static class LazyHolder {
        // Загрузка классов в java делается только по требованию
        // При первом обращении к классу он загрузится
        private static final Something INSTANCE = new Something();
    }

    public static Something getInstance() {
        return LazyHolder.INSTANCE;
    }

}
