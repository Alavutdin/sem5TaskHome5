package ru.example.spring_data_examHome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.spring_data_examHome.model.Task;
import ru.example.spring_data_examHome.model.TaskStatus;

import java.util.List;
/**
 * Репозиторий для сущностей Задач
 * */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Получить список задач по статусу
     * @param status Статус задачи
     * @return Список задач с указанным статусом
     */
    List<Task> findByStatus(TaskStatus status);
}
