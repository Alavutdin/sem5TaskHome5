# Урок 5. Spring Data для работы с базами данных

## План урока 

Базы данных  Spring Data: 

Обобщение  и упрощение работы с базами данных  

Конфигурации Spring Data  

Техническое задание на разработку Spring приложения

## Конфигурация Spring Data с помощью Java кода

@EnableJpaRepositories: Эта аннотация активирует создание репозиториев Spring Data.   

@EnableTransactionManagement: Эта аннотация включает поддержку управления транзакциями Spring.   Методы, аннотированные 

@Bean, создают различные компоненты, необходимые для работы JPA.

## Практическое задание:

Условие:

Предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. 
Требуется реализовать следующие функции:

Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере: 
@GetMapping("/status/{status}") public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
Изменение статуса задачи. Подсказка метод в контроллере: 
@PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
Удаление задачи.
Подсказка метод в контроллере:
@DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id)

Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long>

Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

Подсказка понадобится энумератор:
enum TaskStatus {
NOT_STARTED, IN_PROGRESS, COMPLETED;
}