## Implementasi Repository Pattern
>*"Tenang, gak semenakutkan istilahnya. Ini cuma pendekatan gimana kita mengelola kode untuk komunikasi ke database.""*

Repository pattern pada intinya membuat class yang berisi method-method untuk mengambil data ke database. Biasanya satu class repository untuk satu class model atau repository yang dikhususkan untuk agregasi dari beberapa tabel (tapi ini mungkin belum butuh, silahkan eksplor sendiri).

Untuk penerapannya:
1) Buat package baru bernama `repository`
2) Sebagai best practices, kita akan mendefinisikan kontrak dengan interface untuk membuat repository dengan fungsionalitas CRUD. Di dalam `repository`, buat interface `IDataAccess<T>`. Silahkan salin
```java
package repository;

import java.util.List;
import java.util.Optional;

public interface IDataAccess<T> {
    List<T> getAll();
    Optional<T> getById(int id);
    void insert(T entity);
    void update(T entity);
    void delete(int id);
}

```

3) Buat class `StudentRepository` yang mengimplementasikan interface `IDataAccess<T>`, gunakan class `Student` sebagai tipe data yang digunakan.
```java
package repository;

import model.Student;

import java.util.List;
import java.util.Optional;

public class StudentRepository implements IDataAccess<Student> {
    @Override
    public List<Student> getAll() {
        return List.of();
    }

    @Override
    public Optional<Student> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void insert(Student entity) {

    }

    @Override
    public void update(Student entity) {

    }

    @Override
    public void delete(int id) {

    }
}
```

>*"Penjelasan sistematisnya cukup sampai sini, sisanya silahkan rujuk ke komentar yang ada di kode program asli :D Semangat!"*
