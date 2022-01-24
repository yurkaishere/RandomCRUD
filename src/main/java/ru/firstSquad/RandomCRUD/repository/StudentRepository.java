package ru.firstSquad.RandomCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.firstSquad.RandomCRUD.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
