package repository;

import model.Course;

import java.util.List;
import java.util.Optional;

// Silahkan implementasi mandiri :D
public class CourseRepository implements IDataAccess<Course> {
    @Override
    public List<Course> getAll() {
        return List.of();
    }

    // Method ini bisa diabaikan
    @Override
    public Optional<Course> getById(int id) {
        return Optional.empty();
    }

    // Implementasi saja method yang ini
    public Optional<Course> getByCode(String code) {
        return Optional.empty();
    }

    @Override
    public void insert(Course entity) {

    }

    @Override
    public void update(Course entity) {

    }

    @Override
    public void delete(int id) {

    }
}
