-- MySQL Workbench Forward Engineering


SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Schema cruisedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `forum_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `cruisedb`;

START TRANSACTION;
USE `forum_db`;
INSERT INTO `forum_db`.`subject` (`id`, `subject_name`)
VALUES (1, 'DEATH METAL');
INSERT INTO `forum_db`.`subject` (`id`, `subject_name`)
VALUES (2, 'BLACK METAL');
INSERT INTO `forum_db`.`subject` (`id`, `subject_name`)
VALUES (3, 'DOOM METAL');
INSERT INTO `forum_db`.`subject` (`id`, `subject_name`)
VALUES (4, 'ALTERNATIVE METAL');
INSERT INTO `forum_db`.`subject` (`id`, `subject_name`)
VALUES (5, 'PROGRESSIVE METAL');
COMMIT;

