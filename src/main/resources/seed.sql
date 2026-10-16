INSERT INTO students (id, name, email) VALUES
                                           (1, 'Andi Pratama', 'andi.pratama@example.com'),
                                           (2, 'Budi Santoso', 'budi.santoso@example.com'),
                                           (3, 'Citra Lestari', 'citra.lestari@example.com'),
                                           (4, 'Dewi Anggraini', 'dewi.anggraini@example.com'),
                                           (5, 'Eka Saputra', 'eka.saputra@example.com'),
                                           (6, 'Fajar Ramadhan', 'fajar.ramadhan@example.com'),
                                           (7, 'Gita Maharani', 'gita.maharani@example.com'),
                                           (8, 'Hendra Wijaya', 'hendra.wijaya@example.com'),
                                           (9, 'Intan Permata', 'intan.permata@example.com'),
                                           (10, 'Joko Purnomo', 'joko.purnomo@example.com');

INSERT INTO courses (code, name, credits, class_capacity) VALUES
                                                              ('IF1010001', 'Pemrograman Dasar', 3, 30),
                                                              ('IF1020001', 'Struktur Data', 3, 30),
                                                              ('IF1030001', 'Basis Data', 3, 25),
                                                              ('IF1040001', 'Pemrograman Berorientasi Objek', 3, 25),
                                                              ('IF1050001', 'Rekayasa Perangkat Lunak', 3, 25),
                                                              ('IF1060001', 'Jaringan Komputer', 3, 30),
                                                              ('IF1070001', 'Sistem Operasi', 3, 30),
                                                              ('IF1080001', 'Kecerdasan Buatan', 3, 20);

INSERT INTO enrollments (id, student_id, course_code, enrolled_at, status) VALUES
                                                                               (1, 1, 'IF1010001', '2026-08-01 08:00:00', 'ACTIVE'),
                                                                               (2, 1, 'IF1020001', '2026-08-01 08:05:00', 'ACTIVE'),
                                                                               (3, 1, 'IF1030001', '2026-08-01 08:10:00', 'ACTIVE'),
                                                                               (4, 2, 'IF1010001', '2026-08-01 08:15:00', 'ACTIVE'),
                                                                               (5, 2, 'IF1040001', '2026-08-01 08:20:00', 'ACTIVE'),
                                                                               (6, 2, 'IF1060001', '2026-08-01 08:25:00', 'DROPPED'),
                                                                               (7, 3, 'IF1010001', '2026-08-02 09:00:00', 'ACTIVE'),
                                                                               (8, 3, 'IF1030001', '2026-08-02 09:05:00', 'ACTIVE'),
                                                                               (9, 3, 'IF1050001', '2026-08-02 09:10:00', 'ACTIVE'),
                                                                               (10, 4, 'IF1020001', '2026-08-02 09:15:00', 'ACTIVE'),
                                                                               (11, 4, 'IF1040001', '2026-08-02 09:20:00', 'ACTIVE'),
                                                                               (12, 5, 'IF1030001', '2026-08-03 10:00:00', 'ACTIVE'),
                                                                               (13, 5, 'IF1060001', '2026-08-03 10:05:00', 'ACTIVE'),
                                                                               (14, 6, 'IF1040001', '2026-08-03 10:10:00', 'ACTIVE'),
                                                                               (15, 6, 'IF1070001', '2026-08-03 10:15:00', 'ACTIVE'),
                                                                               (16, 7, 'IF1050001', '2026-08-04 11:00:00', 'ACTIVE'),
                                                                               (17, 7, 'IF1080001', '2026-08-04 11:05:00', 'ACTIVE'),
                                                                               (18, 8, 'IF1060001', '2026-08-04 11:10:00', 'ACTIVE'),
                                                                               (19, 9, 'IF1070001', '2026-08-05 13:00:00', 'DROPPED'),
                                                                               (20, 10, 'IF1080001', '2026-08-05 13:05:00', 'ACTIVE');