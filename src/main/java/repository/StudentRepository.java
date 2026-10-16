package repository;

import config.DBUtil;
import model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// PENTING jangan sampai kebalik
// statement.executeQuery() -> BACA data
// statement.executeUpdate() -> NULIS data
//
// Cek kode di bawah untuk lebih detail

public class StudentRepository implements IDataAccess<Student> {
    @Override
    public List<Student> getAll() {
        // 1) Definisikan dulu sintaks SQL-nya
        String sql = "SELECT id, name, email FROM students";
        // 2) Membuat array dinamis untuk menampung data hasil query
        List<Student> students = new ArrayList<>();

        // 3) Penggunaan try-with-resources, di sini langsung menggunakan
        // PreparedStatement, secara konsep sama seperti Statement
        // untuk alur open-closenya, tidak perlu takut :D
        try (
                Connection connection = DBUtil.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {
            // 4) Mengambil data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                Student student = new Student(id, name, email);
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            throw new IllegalStateException("Gagal mengambil semua data student", e);
        } // 5) Dengan try-with-resources gak perlu repot-repot close koneksi, karena
        // sudah di-handle otomatis oleh Java
    }

    @Override
    public Optional<Student> getById(int id) {
        // 1) Dengan PreparedStatement, gunakan `?` sebagai "penanda"
        // dari letak di mana nilai yang ingin dimasukkan
        String sql = "SELECT id, name, email FROM students WHERE id = ?";

        try (
                Connection connection = DBUtil.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            // 2) Sesuaikan dengan tipe datanya, .setInt(), .setString(), dan lainnya (minta AI aja)
            // Implementasinya tetap sama, misal .setInt(A, B);
            // A -> Posisi urutan dari ?-nya
            // B -> Nilai aslinya
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int studentId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");

                    Student student = new Student(studentId, name, email);
                    return Optional.of(student);
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Gagal mengambil student dengan id " + id, e);
        }
    }

    // Untuk kasus WRITE, (create, update, delete)
    // Kita tidak menggunakan ResultSet karena kita tidak membaca data
    // Setelah execute langsung selesai
    @Override
    public void insert(Student entity) {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";

        try (
                Connection connection = DBUtil.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Gagal menambahkan student", e);
        }
    }

    @Override
    public void update(Student entity) {
        String sql = "UPDATE students SET name = ?, email = ? WHERE id = ?";

        try (
                Connection connection = DBUtil.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getEmail());
            statement.setInt(3, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Gagal memperbarui student dengan id " + entity.getId(), e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (
                Connection connection = DBUtil.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Gagal menghapus student dengan id " + id, e);
        }
    }
}
