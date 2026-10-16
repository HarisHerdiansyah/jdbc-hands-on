## Java Database Connectivity (JDBC)

Java Database Connectivity (JDBC) adalah kode bawaan Java yang berfungsi sebagai standar untuk menghubungkan aplikasi Java dengan *database*. Kode ini sudah tersedia di dalam platform Java dan dapat digunakan cukup dengan mengimpor *package* `java.sql` atau `javax.sql` (misalnya melalui deklarasi `import java.sql.*;`).

Secara definisi formal, JDBC adalah sebuah API (*Application Programming Interface*). Istilah API digunakan karena JDBC pada dasarnya hanya berisi kumpulan *interface*. Dalam konsep *Object-Oriented Programming* (OOP) Java, sebuah *interface* hanyalah sebuah "kontrak" yang berisi deklarasi (seperti nama *method*, *return type*, dan parameter) tanpa adanya implementasi logika di dalamnya.

Karena *method-method* di dalam JDBC hanyalah kerangka kosong, kita bisa menulis dan memanggil *method* tersebut di dalam kode Java kita, tetapi *method* itu sendiri belum bisa benar-benar melakukan pekerjaan apa pun.

Lalu, bagaimana agar kontrak kerangka bawaan Java ini bisa benar-benar menjalankan fungsinya dan melakukan koneksi ke *database* sungguhan?

> *"Jika masih bingung dengan konsep interface, anggaplah interface ini sebagai 'bahasa baku' bagi kita (programmer Java) untuk meminta sesuatu kepada database, terlepas dari merek atau jenis database apa pun yang akan kita gunakan nantinya."*

## Database Driver

Untuk mengisi "kekosongan logika" pada antarmuka JDBC tadi, kita membutuhkan **Database Driver**. *Database Driver* inilah penghubung nyata antara aplikasi Java dengan mesin *database*.

*Driver* berisi kode program Java sungguhan yang secara spesifik **mengimplementasikan** kerangka *interface* yang ada di dalam JDBC API. Berkat adanya *driver*, kita tidak perlu repot-repot menulis kode rumit dari nol tentang bagaimana cara membuka jalur jaringan (*socket* TCP/IP) agar aplikasi bisa mengobrol dengan *database*.

Tugas kita sebagai *programmer* sangat sederhana: cukup pasang *driver* tersebut ke dalam *project* aplikasi, lalu gunakan *method-method* standar dari JDBC untuk bekerja. Sisanya, *driver* yang akan menerjemahkan perintah kita ke dalam bahasa yang dipahami oleh *database*.

Biasanya, *driver* ini dibuat dan disediakan langsung oleh vendor penyedia layanan *database* itu sendiri. Sebagai contoh, MySQL menyediakan *driver* khusus untuk produk MySQL, begitu pula PostgreSQL membuat implementasi *driver* khusus untuk PostgreSQL.

**Apakah implementasi *driver* yang berbeda-beda ini akan mengubah atau merusak kode aplikasi Java kita?**
Tentu saja **Tidak**. Inilah kehebatan utama dari penggunaan *interface*. Karena aplikasi kita sejak awal hanya patuh pada "kontrak" standar JDBC, kita cukup menulis satu jenis gaya kode Java dan memanggil *method* yang sama, tanpa perlu memedulikan detail rumit dari *driver* mana yang sedang bekerja di belakang layar. Perbedaan mendasarnya nanti hanyalah pada dialek atau sintaks perintah SQL yang akan kita kirimkan, bergantung pada aturan *database* yang kita pakai.