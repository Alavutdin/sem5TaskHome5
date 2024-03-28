package ru.example.spring_data_examHome.model;

/**
 * Перечисление статуса задач
 * */
public enum TaskStatus {
    NOT_STARTED{
        @Override
        public String toString() {
            return "Не выполняется";
        }
    }, IN_PROGRESS{
        @Override
        public String toString() {
            return "Выполняется";
        }
    }, COMPLETED{
        @Override
        public String toString() {
            return "Завершена";
        }
    };
}
