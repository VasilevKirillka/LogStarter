# LogStarter

Реализация стартера для отлавливания и логирования запросов и ответов приложения.

# Запуск и использование стартера

Командой `git clone <URL__репозитория>` клонировать проект, либо скачать и распаковать архив, открыть стартер в IntellIj Idea.
Выполнить команду `publishToMavenLocal` , для добавления стартера в локальный репозиторий.
В основном проекте добавить зависимость `implementation("com.example:bootstarterlog:0.0.1-SNAPSHOT")`, 
над нужными методамми добавить аннотацию @LoggingRequest: 
```
  @LoggingRequest
  @GetMapping("/{id}")
  public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
    return ResponseEntity.ok().body(service.getUser(id));
  }
```  
Для сключения стартера в application.yml добавить:
```
logging-request:
    enabled: true
```

