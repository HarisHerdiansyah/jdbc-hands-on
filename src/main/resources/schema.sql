CREATE TABLE `students` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT ''
);

CREATE TABLE `courses` (
  `code` char(9) PRIMARY KEY,
  `name` varchar(50) NOT NULL DEFAULT '',
  `credits` int NOT NULL DEFAULT 1,
  `class_capacity` int NOT NULL DEFAULT 1
);

CREATE TABLE `enrollments` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `course_code` char(9) NOT NULL,
  `enrolled_at` timestamp,
  `status` ENUM ('ACTIVE', 'DROPPED') NOT NULL DEFAULT 'ACTIVE'
);

ALTER TABLE `enrollments` ADD FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);
ALTER TABLE `enrollments` ADD FOREIGN KEY (`course_code`) REFERENCES `courses` (`code`);
