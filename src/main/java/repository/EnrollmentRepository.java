package repository;

import model.Enrollment;

import java.util.List;
import java.util.Optional;

// Silahkan implementasi mandiri :D
public class EnrollmentRepository implements IDataAccess<Enrollment> {
    @Override
    public List<Enrollment> getAll() {
        return List.of();
    }

    @Override
    public Optional<Enrollment> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void insert(Enrollment entity) {

    }

    @Override
    public void update(Enrollment entity) {

    }

    @Override
    public void delete(int id) {

    }

    // Query khusus di luar kontrak
    // Mencari data enrollment dengan filter id student, id course, dan status active
    public Optional<Enrollment> findActiveByStudentAndCourse(int studentId, String courseCode) {}

    // Query khsusu di luar kontrak
    // Mencari total course yang active dari id course tertentu
    public long countActiveByCourse(String courseCode) {}
}
