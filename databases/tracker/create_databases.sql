DROP DATABASE IF EXISTS tracker_dev;
DROP DATABASE IF EXISTS tracker_test;

CREATE DATABASE tracker_dev;
CREATE DATABASE tracker_test;



GRANT ALL PRIVILEGES ON tracker_dev.* TO 'root@localhost';
GRANT ALL PRIVILEGES ON tracker_test.* TO 'root@localhost';