## Komponen Utama

Dalam konteks komunikasi aplikasi Java dengan *database*, kita menggunakan antarmuka dari JDBC. Jika kita membedah cerita perpustakaan di atas, ada enam komponen utama yang saling bekerja sama dan wajib dipahami:

**1. JDBC URL (Alamat Gedung)**
Ini adalah *link* atau tautan yang menunjukkan secara spesifik di mana *database* kita hidup dan berjalan. Strukturnya umumnya terlihat seperti ini: `jdbc:mysql://<hostname>:<port>/<nama_database>`. Ibaratnya, ini adalah peta jalan atau alamat lengkap menuju Gedung Perpustakaan yang akan kamu datangi.

**2. Kredensial Database (Identitas Mahasiswa)**
Ini adalah *username* dan *password* dari *database* kita. Dalam cerita, kredensial ini persis seperti identitas sah mahasiswa beserta informasi sensitif yang wajib kamu serahkan di awal untuk membuktikan bahwa kamu berhak masuk ke dalam perpustakaan.

**3. Class `DriverManager` (Satpam Pintu Masuk)**
Sebuah *class* bawaan dari *package* `java.sql.DriverManager` yang bertugas memvalidasi *driver* dan membukakan jalur koneksi ke *database*. `DriverManager` ini bertindak layaknya satpam di pintu masuk yang akan menerima identitas (kredensial) kamu dan memprosesnya agar gerbang perpustakaan bisa dibuka.

**4. Interface `Connection` (Kartu Akses / Sesi Kunjungan)**
Berasal dari *package* `java.sql.Connection`, antarmuka ini bertugas mewakili dan memelihara sesi koneksi yang aktif dengan *database*. Jika *database* adalah ruang perpustakaan itu sendiri, maka objek `Connection` ini adalah "kartu akses" atau izin tinggal yang aktif kamu gunakan selama berkomunikasi di dalamnya.

**5. Interface `Statement` (Pengelola & Instruksi)**
Berasal dari *package* `java.sql.Statement`, antarmuka ini bertugas menerima dan mengirimkan sintaks perintah SQL dari aplikasi Java ke *database*. Dalam cerita kita, ini mirip dengan sang pengelola perpustakaan—pihak yang menerima permintaan spesifik dari kamu ("tolong carikan paper") lalu mengeksekusinya ke dalam rak-rak arsip.

**6. Interface `ResultSet` (Asisten & Kotak Arsip)**
Berasal dari *package* `java.sql.ResultSet`, antarmuka ini bertugas menampung sekumpulan data hasil dari *query* pencarian *database* (seperti `SELECT`). `ResultSet` inilah wujud nyata dari sang asisten yang bertugas memegang kotak arsip berisi tumpukan *paper*. Saat kamu memanggil fungsi seperti `rs.next()`, itu persis seperti momen di mana kamu bertanya kepada sang asisten: *"Hai, apakah masih ada paper selanjutnya di dalam kotak? Jika iya, tolong berikan pada saya."*
