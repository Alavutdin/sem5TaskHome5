package ru.example.spring_data_examHome.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.spring_data_examHome.model.Task;
import ru.example.spring_data_examHome.model.TaskStatus;
import ru.example.spring_data_examHome.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;
/**
 * Контроллер для управления Задачами
 * */
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    /**
     * Добавляет новые задачи в список
     * @param task Новая  задача
     * @return  возвращаем новую задачу
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        task.setCreatedDate(LocalDateTime.now());
        return taskService.addTask(task);
    }

    /**
     * Просмотр всех задач
     * Получение списка всех задач.
     * @return возвращаем список всех задач.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }


    /**
     * Просмотр задач по статусу
     * @param status    статус задач
     * @return список задач одного статуса
     */
    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable TaskStatus status){
        return taskService.findByStatus(status);
    }


    /**
     * Обновление статуса задачи по её id
     * @param id    id задачи
     * @param task сама задача
     * @return  вернется обновленная задача с новым статусом.
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTaskStatus(id,task);
    }

    /**
     * Удаление задачи по её ID
     * @param id ID задачи Идентифицирует id
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
