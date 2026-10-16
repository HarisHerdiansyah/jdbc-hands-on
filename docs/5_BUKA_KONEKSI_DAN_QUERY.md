## Memulai Koneksi ke Database
Di `Main.java`, kamu bisa salin kode berikut:
```java
// 1) Import dulu package-nya
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // 2) Siapkan kredensialnya
        String jdbcUrl = "jdbc:mysql://localhost:3306/course_registration";
        String jdbcUsername = "root"; // Disesuaikan dengan username database kalian
        String jdbcPassword = "yamabuki"; // Disesuaikan dengan password database kalian, kalo kosong cukup string kosong saja

        // 3) Mulai buka koneksi, jangan lupa bungkus pakai try-catch-finally :D
        Connection connection = null; // 4) Siapkan dulu wadahnya
        try {
            // 5) Buka koneksi lewat perantara DriverManager, simpen "hak akses"-nya di objek connection
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            System.out.println("Koneksi berhasil :D");
        } catch (SQLException e) {
            System.err.println("Membuka koneksi gagal :(");
        } finally {
            // 6) Cek dulu null atau tidak, kalau misal null, artinya sebelumnya proses koneksi gagal
            if (connection != null) {
                try {
                    // 7) Menutup koneksi harus pakai try-catch juga, setiap proses komunikasi harus dibungkus try-catch
                    connection.close();
                    System.out.println("Menutup koneksi berhasil :D");
                } catch (SQLException e) {
                    System.err.println("Menutup koneksi gagal :(");
                }
            }
        }
    }
}

```
> *"Iya, kodenya memang panjang dan pasti bikin overwhelm :("*

## Membaca Data dari Java
Tambahkan baris-baris kode yang diperlukan, sesuai penjelasan yang disertakan melalui komentar kode
```java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement; // 1) Import interface Statement dan ResultSet
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/course_registration";
        String jdbcUsername = "root";
        String jdbcPassword = "yamabuki";

        Connection connection = null;
        Statement statement = null; // 2) Buat wadahnya

        try {
            // 3) Buka koneksi ke database dengan memasukkan kredensial
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 4) Membuat pernyataan bahwa kita mau melakukan query
            // Di dalam cerita, ini seperti menghampiri pengelola perpustakaan
            statement = connection.createStatement();

            // 5) Lakukan query dengan memanggil method .executeQuery(sql);
            // dan simpan hasilnya di resultSet. Dalam konteks ini, kita menyampaikan
            // kebutuhan kita ke pengelola perpustakaan
            String sql = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(sql);

            // 6) ResultSet adalah orang yang mengantar arsip berisi paper yang kita
            // minta, dia akan memberikannya satu per satu
            //
            // Secara teknis, kita menggunakan .next() artinya memeriksa apakah data
            // di baris selanjutnya masih ada
            while (resultSet.next()) {
                // 7) Untuk mengambil data, gunakan objek resultSet diikuti sebuah method
                // bisa gunakan .getString(), .getInt(), atau .getBoolean()
                // tergantung tipe data dari nama kolom di tabel kalian
                // misal di sini ingin mengambil `name` yang bertipe VARCHAR() atau String
                System.out.println(resultSet.getString("name"));
            }

            // 8) Menutup resultSet
            // Di dalam cerita, ini seperti meminta petugas yang membawakan arsip
            // bahwa tugasnya sudah selesai
            resultSet.close();
        } catch (SQLException e) {
            System.err.println("Membuka koneksi gagal :(");
        } finally {
            // 9) Menutup statement
            // Di dalam cerita, ini seperti meminta pengelola perpustakaan
            // bahwa tugasnya sudah selesai
            if (statement != null) {
                try {
                    statement.close();
                    System.out.println("Menutup statement berhasil :D");
                } catch (SQLException e) {
                    System.err.println("Menutup statement gagal :(");
                }
            }

            // 10) Menutup koneksi
            // Mengembalikan hak akses kita ke satpam perpustakaan
            // sebagai tanda kalau urusan kita sudah selesai
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Menutup koneksi berhasil :D");
                } catch (SQLException e) {
                    System.err.println("Menutup koneksi gagal :(");
                }
            }
        }
    }
}
```

> *"Kodenya pusing :("*

> "Ada cara yang lebih elegan kok :D Cek langkah selanjutnya!"

## Penggunaan `try-with-resources`
Menulis kode dengan `try-catch` biasa terkesan repot, Java memiliki satu fitur yang biasa digunakan ketika koneksi ke sistem eksternal (misalnya database), yaitu `try-with-resources`

Struktur kode `try-catch` reguler:
```java
public class Main {
    public static void main(String args[]) {
        try {
            // ... kode yang menyebabkan exception
        } catch (Exception ex) {
            // ... kode yang bakal jalan kalo ada exception
        }
    }
}
```

Struktur kode `try-with-resources`:
```java
public class Main {
    public static void main(String args[]) {
        // Ada tambahan kurung buka dan tutup sebelum kurung kurawal, 
        // di sini kita memanggil method yang melibatkan sistem eksternal
        try (...) { 
            // ... kode yang menyebabkan exception
        } catch (Exception ex) {
            // ... kode yang bakal jalan kalo ada exception
        }
    }
}
```

Pembaruan `Main.java` dengan `try-with-resources`:
```java
// 1) Daftar package yang digunakan masih sama
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // 2) Kredensial masih sama
        String jdbcUrl = "jdbc:mysql://localhost:3306/course_registration";
        String jdbcUsername = "root";
        String jdbcPassword = "yamabuki";

        // 3) Penggunaan try-with-resources
        try (
                Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students")
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Operasi database gagal: " + e.getMessage());
        }
    }
}
```