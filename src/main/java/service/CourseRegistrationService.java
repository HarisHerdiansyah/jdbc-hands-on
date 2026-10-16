package service;

import model.Course;
import repository.CourseRepository;
import repository.EnrollmentRepository;
import repository.StudentRepository;

public class CourseRegistrationService {
    // =========================== DON'T MODIFY ===========================
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public CourseRegistrationService(StudentRepository studentRepository,
                                     CourseRepository courseRepository,
                                     EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    private void ensureStudentExists(int studentId) throws Exception {
        if (studentRepository.getById(studentId).isEmpty()) {
            throw new Exception("Student " + studentId + " tidak ditemukan.");
        }
    }

    private Course findCourse(String courseCode) throws Exception {
        return courseRepository.getByCode(courseCode)
                .orElseThrow(() -> new Exception(
                        "Course " + courseCode + " tidak ditemukan."));
    }
    // =========================== DON'T MODIFY ===========================

    public void enrollCourse(int studentId, String courseCode) throws Exception {
        /*
         * TODO: Implementasikan proses pendaftaran student ke course:
         * 1. Pastikan student dengan studentId tersedia menggunakan
         *    ensureStudentExists(studentId).
         * 2. Ambil course menggunakan findCourse(courseCode), sehingga proses
         *    gagal jika course tidak ditemukan.
         * 3. Periksa apakah sudah ada enrollment ACTIVE untuk student dan course
         *    tersebut melalui findActiveByStudentAndCourse(...). Jika ada,
         *    hentikan proses dengan pesan error yang sesuai.
         * 4. Hitung enrollment ACTIVE pada course menggunakan
         *    countActiveByCourse(courseCode), lalu bandingkan dengan kapasitas
         *    course.getClassCapacity(). Tolak pendaftaran jika course penuh.
         * 5. Jika semua validasi lolos, buat Enrollment baru dengan studentId,
         *    courseCode, waktu LocalDateTime.now(), dan status ACTIVE.
         * 6. Simpan enrollment baru menggunakan enrollmentRepository.insert(...).
         * 7. Biarkan exception dari repository atau validasi diteruskan kepada
         *    pemanggil agar kegagalan tidak ditutupi.
         */
        throw new UnsupportedOperationException("TODO: implementasikan enrollCourse");
    }

    public void dropCourse(int studentId, String courseCode) throws Exception {
        /*
         * TODO: Implementasikan proses pembatalan enrollment:
         * 1. Pastikan student dengan studentId tersedia menggunakan
         *    ensureStudentExists(studentId).
         * 2. Pastikan course dengan courseCode tersedia menggunakan
         *    findCourse(courseCode).
         * 3. Cari enrollment ACTIVE milik student pada course tersebut melalui
         *    findActiveByStudentAndCourse(...). Jika tidak ada, hentikan proses
         *    dengan pesan bahwa enrollment aktif tidak ditemukan.
         * 4. Ubah status enrollment yang ditemukan menjadi DROPPED.
         * 5. Simpan perubahan menggunakan enrollmentRepository.update(...).
         * 6. Biarkan exception dari repository atau validasi diteruskan kepada
         *    pemanggil dan jangan menggantinya dengan exception tanpa cause.
         */
        throw new UnsupportedOperationException("TODO: implementasikan dropCourse");
    }
}
